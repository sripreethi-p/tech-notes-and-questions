package com.dsa.algorithms.controller;

import com.dsa.algorithms.service.sorting.SortingTechniques;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/sorting")
@Slf4j
public class SortingController {
    private final SortingTechniques sortingTechniques;

    public SortingController(SortingTechniques sortingTechniques) {
        this.sortingTechniques = sortingTechniques;
    }

    @GetMapping(value = "/selection")
    public void selectionSort()  {
        int [] array = new int[] { 4, 2, 1, 9, 34, 0, -4 };
        sortingTechniques.selectionSort(array);
    }

    @GetMapping(value = "/bubble")
    public void bubbleSort()  {
        int [] array = new int[] { 4, 2, 1, 9, 34, 0, -4 };
        sortingTechniques.bubbleSort(array);
    }

    @GetMapping(value = "/insertion")
    public void insertionSort()  {
        int [] array = new int[] { 4, 2, 1, 9, 34, 0, -4 };
        sortingTechniques.insertionSort(array);
    }

    @GetMapping(value = "/merge")
    public void mergeSort()  {
        int [] array = new int[] { 4, 2, 1, 9, 34, 0, -4 };
        sortingTechniques.mergeSort(array);
    }

    @GetMapping(value = "/quick")
    public void quickSort()  {
        int [] array = new int[] { 4, 2, 1, 9, 34, 0, -4 };
        sortingTechniques.quickSort(array);
    }
}
