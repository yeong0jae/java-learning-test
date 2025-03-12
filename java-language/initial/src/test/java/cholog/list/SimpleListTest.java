package cholog.list;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class SimpleListTest {

    @Test
    void arrayList() {
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
    void SimpleArrayListTest() {
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
    void SimpleArrayListTest2() {
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

    @Test
    void 배열을_리스트로_변환한다() {
        Integer[] values = {1, 2, 3};

        SimpleList<Integer> integerSimpleList = SimpleList.fromArrayToList(values);

        assertThat(integerSimpleList.get(0)).isEqualTo(1);
        assertThat(integerSimpleList.get(1)).isEqualTo(2);

        String[] values2 = {"a", "b", "c"};

        SimpleList<String> stringSimpleList = SimpleList.fromArrayToList(values2);

        assertThat(stringSimpleList.get(0)).isEqualTo("a");
        assertThat(stringSimpleList.get(1)).isEqualTo("b");
    }

    @Test
    void 리스트의_합을_구한다() {
        SimpleArrayList<Integer> integerSimpleArrayList = new SimpleArrayList<>();
        integerSimpleArrayList.add(1);
        integerSimpleArrayList.add(2);

        assertThat(SimpleList.sum(integerSimpleArrayList)).isEqualTo(3);

        SimpleArrayList<Double> doubleSimpleArrayList = new SimpleArrayList<>();
        doubleSimpleArrayList.add(1.0);
        doubleSimpleArrayList.add(2.0);

        assertThat(SimpleList.sum(doubleSimpleArrayList)).isEqualTo(3);
    }

    @Test
    void 리스트_내의_음수를_제거한다() {
        SimpleList<Integer> simpleList = new SimpleArrayList<>();
        simpleList.add(-1);
        simpleList.add(1);
        simpleList.add(2);
        SimpleList<Double> doubleSimpleList = new SimpleArrayList<>();
        doubleSimpleList.add(-1.0);
        doubleSimpleList.add(1.0);
        doubleSimpleList.add(2.0);

        SimpleList<Integer> filteredList = SimpleList.filterNegative(simpleList);
        SimpleList<Double> doubleFilteredList = SimpleList.filterNegative(doubleSimpleList);

        assertThat(filteredList.get(0)).isEqualTo(1);
        assertThat(filteredList.get(1)).isEqualTo(2);

        assertThat(doubleFilteredList.get(0)).isEqualTo(1.0);
        assertThat(doubleFilteredList.get(1)).isEqualTo(2.0);
    }

    @Test
    void 리스트_복사하기() {
        var laserPrinter = new LaserPrinter();

        SimpleList<Printer> printers = new SimpleArrayList<>();
        SimpleList<LaserPrinter> laserPrinters = new SimpleArrayList<>();
        laserPrinters.add(laserPrinter);

        // laserPrinters -> printers 에 복사
        SimpleList.copy(laserPrinters, printers);

        System.out.println(printers.get(0) == laserPrinter);
    }
}
