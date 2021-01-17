package com.example.demo;

import com.example.demo.composite.Embedded.Entity.*;
import com.example.demo.composite.Embedded.Repository.PayRepository;
import com.example.demo.composite.Embedded.Repository.PayShopRepository;
import com.example.demo.composite.IdClass.Entity.*;
import com.example.demo.composite.IdClass.Repository.Pay2Repository;
import com.example.demo.composite.IdClass.Repository.PayDetail2Repository;
import com.example.demo.composite.IdClass.Repository.PayShop2Repository;
import com.example.demo.manyToMany.Entity.Course;
import com.example.demo.manyToMany.Entity.Student;
import com.example.demo.manyToMany.Repository.CourseRepository;
import com.example.demo.manyToMany.Repository.StudentRepository;
import com.example.demo.oneToMany.Repository.ChildRepository;
import com.example.demo.oneToMany.Repository.MomRepository;
import com.example.demo.oneToMany.Entity.Child;
import com.example.demo.oneToMany.Entity.Mom;
import com.example.demo.oneToOne.Entity.Gender;
import com.example.demo.oneToOne.Entity.Person;
import com.example.demo.oneToOne.Repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
//@Slf4j
//@Service
@RequiredArgsConstructor
public class DemoApplication {
    //OneToMany
    private final MomRepository momRepository;
    private final ChildRepository childRepository;

    //OneToOne
    private final PersonRepository personRepository;
//    private final GenderRepository genderRepository;

    //ManyToMany
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    //composite - embeddedId
    private final PayRepository payRepository;
    private final PayShopRepository payShopRepository;

    //composite - IdClass
    private final Pay2Repository pay2Repository;
    private final PayShop2Repository payShop2Repository;
    private final PayDetail2Repository payDetail2Repository;

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner oneToMany()
    {
        return args -> {
            System.out.println("OneToMany");
          Mom mom = new Mom("title");
          momRepository.save(mom);

          childRepository.save(new Child("sub title1", mom));
          childRepository.save(new Child("sub title2", mom));
        };
    }

    @Bean
    public CommandLineRunner oneToOne()
    {
        return args -> {
            System.out.println("oneToOne");

            Person person = new Person("kyuli");
            Gender gender = new Gender(false);

            person.setGender(gender);
            gender.setPerson(person);

            // 부모를 저장하면 자식도 자동 저장
            personRepository.save(person);

        };
    }

    @Bean
    public CommandLineRunner manyToMany()
    {
        return args -> {
            System.out.println("manyToMany");

            Student student = new Student("kyuli");

            //save
            studentRepository.save(student);

            Course course1 = new Course("course1");
            Course course2 = new Course("course2");
            Course course3 = new Course("course3");

            courseRepository.saveAll(Arrays.asList(course1, course2, course3));

            student.getCourses().addAll(Arrays.asList(course1, course2, course3));

            //update
            studentRepository.save(student);

        };
    }

    @Bean
    public CommandLineRunner compositeEmbedded()
    {
        return args -> {
            System.out.println("composite embeddedId");
            //PK

            PayId payId = new PayId(10L, 20L);
            payRepository.save(new Pay(payId));

            payShopRepository.save(new PayShop(new PayShopId(new PayDetailId(payId, 1L), "12"), "frist shop"));

            Optional<Pay> pays = payRepository.findById(payId);
            pays.ifPresent(System.out::println);
//            List
//            pays.forEach(System.out::println);
        };
    }

    @Bean
    public CommandLineRunner compositeIdClass()
    {
        return args -> {
            System.out.println("composite IdClass");
            //FK

            Pay2 pay2 = new Pay2(5L, 3L);

            pay2Repository.save(pay2);

            PayDetail2 payDetail2 = new PayDetail2(5L, 3L, 1L);
            PayShop2 payShop2 = new PayShop2(5L, 3L, 1L, "sss", "sss");
            payShop2.setPayDetail2(payDetail2);
            payShop2.setPay2(pay2);

            payShop2Repository.save(payShop2);

            Optional<Pay2> findPay2 = pay2Repository.findById(new PayId2(5L, 3L));
            findPay2.ifPresent(System.out::println);

            Optional<PayShop2> findPayShop2 = payShop2Repository.findById(new PayShopId2(5L, 3L, 1L, "sss"));

            findPayShop2.ifPresent(System.out::println);

        };
    }

}
