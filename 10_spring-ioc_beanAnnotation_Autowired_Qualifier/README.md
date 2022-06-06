### IOC操作Bean管理（基于注解方式）- 属性注入

1、@Autowired - 根据**属性类型**进行自动装配注入byType
	1）第一步 把service和dao对象创建，在service和dao类上添加注解
	2）第二步 在service注入dao对象：在service类添加dao类型属性，在属性上面使用注解 - 注意使用注解则不需要添加setter方法了，因为已经spring的注解已经帮忙封装好了

```java
public interface BookDao {
    public void add();
}

@Repository
public class BookDaoImpl implements BookDao {

    public void add() {
        System.out.println("BookDaoImpl.add() - book dao add...");
    }
}

@Service
public class BookServiceAutowired {

    // service上调用dao，需要定义dao类型属性
    // 注意这里不需要添加setter方法
    @Autowired // 根据类型进行注入：byType
    private BookDao bookDao;

    public void add() {
        System.out.println("BookServiceAutowired.add() - book service add.....");
        // 为了体现属性注入效果，在这里打印dao方法
        bookDao.add();
    }
}

@Test
public void testAutowired() {
  ApplicationContext context = new ClassPathXmlApplicationContext("beanAnnotations.xml");
  BookServiceAutowired bookServiceAutowired = context.getBean("bookServiceAutowired", BookServiceAutowired.class);
  bookServiceAutowired.add();
}
```



2、@Qualifier - 根据**属性名称**进行注入
	*这个@Qualifier注解的使用，一般都是和@Autowired一起使用，适用于接口属性，且接口属性有多个实现类

```java
public interface UserDao {
    public void add();
}

@Repository
public class UserDaoImpl implements UserDao {

    public void add() {
        System.out.println("UserDaoImpl.add() - user dao add.....");
    }
}

@Repository(value="userDaoImpl2")
public class UserDaoImpl2 implements UserDao {

    public void add() {
        System.out.println("UserDaoImpl2.add() - user dao add.....");
    }
}

@Service
public class UserServiceQualifier {

    // service上调用dao，需要定义dao类型属性
    // 注意这里不需要添加setter方法
    @Autowired // 根据类型进行注入：byType
    @Qualifier(value="userDaoImpl2") // 假如有多个实现类的时候，指定名称选择对应实现类来注入指定实现类类依赖对象
    private UserDao userDao;

    public void add() {
        System.out.println("UserServiceQualifier.add() - user service add.....");
        // 为了体现属性注入效果，在这里打印dao方法
        userDao.add();
    }
}

@Test
public void testQualifier() {
  ApplicationContext context = new ClassPathXmlApplicationContext("beanAnnotations.xml");
  UserServiceQualifier userServiceQualifier = context.getBean("userServiceQualifier", UserServiceQualifier.class);
  userServiceQualifier.add();
}
```



3、@Resource - 根据属性类型注入，也可以根据属性名称注入
	*注意：这个注解属于**javax.annotation.Resource**包，spring官方并不是很推荐使用

```java
public interface WorkerDao {
    public void add();
}

//@Repository // 根据类型注入
@Repository(value = "workerDaoImpl")  // 根据名称注入
public class WorkerDaoImpl implements WorkerDao{

    public void add() {
        System.out.println("WorkerDaoImpl.add() - worker dao add.....");
    }
}

@Service
public class WorkerServiceResource {

//    @Resource // 根据类型注入
    @Resource(name="workerDaoImpl") // 根据名称注入
    private WorkerDao workerDao;

    public void add() {
        System.out.println("WorkerServiceResource.add() - worker service add.....");
        workerDao.add();
    }
}

@Test
public void testResource() {
  ApplicationContext context = new ClassPathXmlApplicationContext("beanAnnotations.xml");
  WorkerServiceResource workerServiceResource = context.getBean("workerServiceResource", WorkerServiceResource.class);
  workerServiceResource.add();
}
```



4、@Value - 普通类型属性注入

```java
@Service
public class ValueNormalDataInjectionService {

    @Value(value = "abc")
    private String str;

    public void valueTest() {
        System.out.println("使用@Value注入的值为：" + str);
    }
}

@Test
public void testValue() {
  ApplicationContext context = new ClassPathXmlApplicationContext("beanAnnotations.xml");
  ValueNormalDataInjectionService valueNormalDataInjectionService = context.getBean("valueNormalDataInjectionService", ValueNormalDataInjectionService.class);
  valueNormalDataInjectionService.valueTest();
}
```





