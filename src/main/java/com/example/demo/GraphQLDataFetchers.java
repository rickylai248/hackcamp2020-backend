package com.example.demo;

import com.google.common.collect.ImmutableMap;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class GraphQLDataFetchers {

    private static List<Map<String, String>> employees = Arrays.asList(
            ImmutableMap.of("id", "employee-100",
                    "name", "Jane Doe",
                    "messages", ["You're doing great"])
            ImmutableMap.of("id", "book-2",
                    "name", "Moby Dick",
                    "pageCount", "635", ),
            ImmutableMap.of("id", "employee-102",
                    "name", "Interview with the vampire",
                    "pageCount", "371",
                    "authorId", "author-3")
    );


    public DataFetcher getEmployeeByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String bookId = dataFetchingEnvironment.getArgument("id");
            return books
                    .stream()
                    .filter(book -> book.get("id").equals(bookId))
                    .findFirst()
                    .orElse(null);
        };
    }
}