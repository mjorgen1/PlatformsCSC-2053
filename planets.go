package main
import (
	"fmt"
	"bufio"
	"os"
	"strconv"
	"strings"
)
//planets weight calculation
func calc(y int64, gravity float64) string {
	w := float64(y)
	planetW := int(w * gravity)
	planetStr := strconv.Itoa(planetW)
	return planetStr
}

func main() {
	fmt.Println("Hello! This program will tell you what your weight is on the different planets!")
	reader := bufio.NewReader(os.Stdin)
    fmt.Print("Enter your weight in pounds (lb) on earth: ")
	text, _ := reader.ReadString('\n')
	textDel := strings.Trim(text, "\n")
	weight, _ := strconv.ParseInt(textDel, 10, 32)
	fmt.Println("On Mercury you would weigh (lb): " + calc(weight, .38))
	fmt.Println("On Venus you would weigh (lb): " + calc(weight, 0.91))
	fmt.Println("On Mars you would weigh (lb): " + calc(weight, 0.38))
	fmt.Println("On Jupiter you would weigh (lb): " + calc(weight, 2.34))
	fmt.Println("On Uranus you would weigh (lb): " + calc(weight, 0.92))
	fmt.Println("On Saturn you would weigh (lb): " + calc(weight, 0.93))
	fmt.Println("On Neptune you would weigh (lb): " + calc(weight, 1.12))
	fmt.Println("On Pluto you would weigh (lb): " + calc(weight, .06))
}