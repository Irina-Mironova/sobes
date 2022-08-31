package ru.geekbrains.hw5;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainApp {
    private static SessionFactory factory;
    private static StudentDao studentDao;

    public static void main(String[] args) {
        try {
            factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();
            studentDao = new StudentDao(factory);

            //добавление 1000 записей в таблицу
            for (int i = 0; i < 1000; i++) {
                studentDao.create("Name " + (i + 1), (int) (Math.random() * 5) + 1);
            }

            //поиск и вывод списка всех студентов
            List<Student> list = studentDao.findAll();
            list.stream().forEach(System.out::println);

            //поиск и вывод 1 студента
            Student student = studentDao.findByID(1L);
            System.out.println(student.toString());

            //обновление инф-и о студенте
            studentDao.update(1L, "Саша", 5);

            //удаление инф-и о студенте
            studentDao.delete(2L);

            //поиск и вывод списка всех студентов
            list = studentDao.findAll();
            list.stream().forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}

