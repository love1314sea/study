package 设计模式._02_策略模式._02;


interface Strategy {
    public int compare(Student s1, Student s2);
}

class sortByAge implements Strategy {
    @Override
    public int compare(Student s1, Student s2) {
        if(s1.age == s2.age)
            return s1.id - s2.id;
        else
            return s1.age - s2.age;
    }
}
class sortById implements Strategy {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.id - s2.id;
    }
}

class sortByName implements Strategy {
    @Override
    public int compare(Student s1, Student s2) {
        if( s1.name.equals(s2.name))
            return s1.id - s2.id;
        else
            return s1.name.compareTo(s2.name);
    }
}