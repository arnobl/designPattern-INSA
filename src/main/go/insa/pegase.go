package main

import "fmt"

type Bird struct {
}

func (bird Bird) fly() {
   fmt.Println("fly")
}

type Horse struct {
}

func (horse Horse) gallop() {
    fmt.Println("gallop")
}

type Pegase struct {
// This is not inheritance but composition
  Horse
  Bird
}


func main() {
    var pegase Pegase

    pegase.gallop()
    pegase.fly()
}