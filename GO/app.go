package main

import (
	"fmt"
	"sync"
	"time"
)

func main() {
	var year, month, day, hour, minute int
	var wg sync.WaitGroup
	var validYear, validMonth, validDay, validHour, validMinute bool

	fmt.Print("Enter the year: ")
	fmt.Scan(&year)

	fmt.Print("Enter the month (as a number): ")
	fmt.Scan(&month)

	fmt.Print("Enter the day: ")
	fmt.Scan(&day)

	fmt.Print("Enter the hour: ")
	fmt.Scan(&hour)

	fmt.Print("Enter the minute: ")
	fmt.Scan(&minute)

	wg.Add(5)
	go func() {
		defer wg.Done()
		if year < 0 {
			fmt.Println("Invalid year")
			validYear = false
		} else {
			validYear = true
		}
	}()

	go func() {
		defer wg.Done()
		if month < 1 || month > 12 {
			fmt.Println("Invalid month")
			validMonth = false
		} else {
			validMonth = true
		}
	}()

	go func() {
		defer wg.Done()
		if day < 1 || day > 31 {
			fmt.Println("Invalid day")
			validDay = false
		} else {
			validDay = true
		}
	}()

	go func() {
		defer wg.Done()
		if hour < 0 || hour > 23 {
			fmt.Println("Invalid hour")
			validHour = false
		} else {
			validHour = true
		}
	}()

	go func() {
		defer wg.Done()
		if minute < 0 || minute > 59 {
			fmt.Println("Invalid minute")
			validMinute = false
		} else {
			validMinute = true
		}
	}()

	wg.Wait()

	if validYear && validMonth && validDay && validHour && validMinute {
		date := time.Date(year, time.Month(month), day, hour, minute, 0, 0, time.UTC)
		fmt.Printf("Entered date and time: %s\n", date.Format(time.RFC1123))
	}
}
