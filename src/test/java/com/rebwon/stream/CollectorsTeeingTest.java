package com.rebwon.stream;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public final class CollectorsTeeingTest {

    @Test
    void name() {
        // Arrange
        var list = List.of(
            new Employees(1, "A", 100),
            new Employees(2, "B", 200),
            new Employees(3, "C", 300),
            new Employees(4, "D", 400)
        );

        // Act
        var result = list.stream()
            .collect(Collectors.teeing(
                Collectors.maxBy(Comparator.comparingDouble(Employees::salary)),
                Collectors.minBy(Comparator.comparingDouble(Employees::salary)),
                (e1, e2) -> {
                    var map = new HashMap<String, Employees>();
                    map.put("MAX", e1.get());
                    map.put("MIN", e2.get());
                    return map;
                }
            ));

        // Assert
        assertThat(result.toString()).isEqualTo("{MIN=Employees[id=1, name=A, salary=100.0], MAX=Employees[id=4, name=D, salary=400.0]}");
    }

    @Test
    void name1() {
        // Arrange
        var employees = List.of(
            new Employees(1, "A", 100),
            new Employees(2, "B", 200),
            new Employees(3, "C", 300),
            new Employees(4, "D", 400)
        );

        // Act
        var result = employees.stream()
            .collect(Collectors.teeing(
                Collectors.filtering(e -> e.salary() > 200, Collectors.toList()),
                Collectors.filtering(e -> e.salary() > 200, Collectors.counting()),
                (list, count) -> {
                    var map = new HashMap<String, Object>();
                    map.put("list", list);
                    map.put("count", count);
                    return map;
                }
            ));

        // Assert
        assertThat(result.toString()).isEqualTo("{count=2, list=[Employees[id=3, name=C, salary=300.0], Employees[id=4, name=D, salary=400.0]]}");
    }
}
