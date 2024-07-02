package com.dsa.algorithms.controller;

import com.dsa.algorithms.service.searching.SearchTechniques;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/searching")
@Slf4j
public class SearchingController {
    private final SearchTechniques searchTechniques;

    public SearchingController(SearchTechniques searchTechniques) {
        this.searchTechniques = searchTechniques;
    }

    @GetMapping(value = "/linear")
    public void linearSearch()  {
        int [] array = new int[] { 4, 2, 1, 9, 34, 0, -4 };
        int target = 34;
        int index = searchTechniques.linearSearch(array, target);
        log.info("Found {} at index {} in {} using Linear Search", target, index, array);
    }

    @GetMapping(value = "/binary")
    public void binarySearch()  {
        int [] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int target = 7;
        int index = searchTechniques.binarySearch(array, target);
        log.info("Found {} at index {} in {} using Binary Search", target, index, array);
    }

    @GetMapping(value = "/ternary")
    public void ternarySearch()  {
        int [] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int target = 7;
        int index = searchTechniques.ternarySearch(0, 9, 7, array);
        log.info("Found {} at index {} in {} using Ternary Search", target, index, array);
    }
}
