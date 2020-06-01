import java.util.List;

public class ListCases {
    private List<Integer> list1 = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20); // упорядоченный
    private List<Integer> list2 = List.of(20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1); // обратно упорядоченный
    private List<Integer> list3 = List.of(10,9,8,7,6,5,4,3,2,1,20,19,18,17,16,15,14,13,12,11); // обратно упорядоченный пополам
    private List<Integer> list4 = List.of(9,10,11,9,10,11,20,4,20,25,18,23,55,231,0,123,4,55); // с дублями
    private List<Integer> list5 = List.of(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);// Все числа одинаковы
    private List<Integer> list6 = List.of(2,2,2,2,2,2,2,2,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1);// Два ближних числа
    private List<Integer> list7 = List.of(1);                                                  // Один элемент
    private List<Integer> list8 = List.of();                                                   // Пустой элемент

    public List<Integer> getList1() {
        return list1;
    }

    public List<Integer> getList2() {
        return list2;
    }

    public List<Integer> getList3() {
        return list3;
    }

    public List<Integer> getList4() {
        return list4;
    }

    public List<Integer> getList5() {
        return list5;
    }

    public List<Integer> getList6() {
        return list6;
    }

    public List<Integer> getList7() {
        return list7;
    }

    public List<Integer> getList8() {
        return list8;
    }
}
