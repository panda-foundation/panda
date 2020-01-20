package compiler

import (
	"fmt"
	"sync"
)

type Pos int

const NoPos Pos = 0

func (pos Pos) IsValid() bool {
	return pos != NoPos
}

type Position struct {
	Filename string // filename, if any
	Offset   int    // offset, starting at 0
	Line     int    // line number, starting at 1
	Column   int    // column number, starting at 1 (byte count)
}

func (position *Position) IsValid() bool {
	return position.Line > 0
}

func (position Position) String() string {
	str := position.Filename
	if str == "" {
		str = "<input>"
	}
	if position.IsValid() {
		str += fmt.Sprintf(":%d", position.Line)
		if position.Column != 0 {
			str += fmt.Sprintf(":%d", position.Column)
		}
	}
	return str
}

type File struct {
	mutex sync.Mutex
	name  string
	lines []int
}

func (f *File) LineCount() int {
	f.mutex.Lock()
	n := len(f.lines)
	f.mutex.Unlock()
	return n
}

func (f *File) AddLine(offset int) {
	f.mutex.Lock()
	f.lines = append(f.lines, offset)
	f.mutex.Unlock()
}

func (f *File) Line(p Pos) int {
	return f.Position(p).Line
}

func (f *File) Position(p Pos) (pos Position) {
	offset := int(p)
	pos.Offset = offset
	pos.Filename, pos.Line, pos.Column = f.unpack(offset)
	return
}

func (f *File) unpack(offset int) (filename string, line, column int) {
	f.mutex.Lock()
	defer f.mutex.Unlock()
	filename = f.name
	i, j := 0, len(f.lines)
	for i < j {
		h := i + (j-i)/2 // avoid overflow when computing h
		// i ≤ h < j
		if f.lines[h] <= offset {
			i = h + 1
		} else {
			j = h
		}
	}
	i = i - 1
	if i >= 0 {
		line, column = i+1, offset-f.lines[i]+1
	}
	return
}

type FileSet struct {
	mutex sync.RWMutex // protects the file set
	files []*File      // list of files in the order added to the set
}

func (s *FileSet) AddFile(filename string) *File {
	s.mutex.Lock()
	defer s.mutex.Unlock()
	// base >= s.base && size >= 0
	f := &File{name: filename, lines: []int{0}}
	s.files = append(s.files, f)
	return f
}

func (s *FileSet) Iterate(f func(*File) bool) {
	for i := 0; ; i++ {
		var file *File
		s.mutex.RLock()
		if i < len(s.files) {
			file = s.files[i]
		}
		s.mutex.RUnlock()
		if file == nil || !f(file) {
			break
		}
	}
}
