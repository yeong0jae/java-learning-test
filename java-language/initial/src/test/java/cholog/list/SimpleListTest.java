package cholog.list;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class SimpleListTest {

    @Test
    public void arrayList() {
        ArrayList<String> values = new ArrayList<>();
        values.add("first");
        values.add("second");

        assertThat(values.add("third")).isTrue(); // 세 번째 값을 추가한다.
        assertThat(values.size()).isEqualTo(3); // list의 크기를 구한다.
        assertThat(values.get(0)).isEqualTo("first"); // 첫 번째 값을 찾는다.
        assertThat(values.contains("first")).isTrue(); // "first" 값이 포함되어 있는지를 확인한다.
        assertThat(values.remove(0)).isEqualTo("first"); // 첫 번째 값을 삭제한다.
        assertThat(values.size()).isEqualTo(2); // 값이 삭제 됐는지 확인한다.

        values.forEach(System.out::println);
    }

    @Test
    public void SimpleArrayListTest() {
        SimpleArrayList<String> simpleArrayList = new SimpleArrayList<>(2);
        simpleArrayList.add("first");
        simpleArrayList.add("second");

        assertThat(simpleArrayList.add("third")).isTrue();
        assertThat(simpleArrayList.size()).isEqualTo(3);
        assertThat(simpleArrayList.get(0)).isEqualTo("first");
        assertThat(simpleArrayList.contains("first")).isTrue();
        assertThat(simpleArrayList.remove(0)).isEqualTo("first");
        assertThat(simpleArrayList.size()).isEqualTo(2);
    }

    @Test
    public void SimpleArrayListTest2() {
        SimpleArrayList<Integer> simpleArrayList = new SimpleArrayList<>(2);
        simpleArrayList.add(1);
        simpleArrayList.add(2);

        assertThat(simpleArrayList.add(3)).isTrue();
        assertThat(simpleArrayList.size()).isEqualTo(3);
        assertThat(simpleArrayList.get(0)).isEqualTo(1);
        assertThat(simpleArrayList.contains(1)).isTrue();
        assertThat(simpleArrayList.remove(0)).isEqualTo(1);
        assertThat(simpleArrayList.size()).isEqualTo(2);
    }
}
