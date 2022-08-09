# Spring-Study

## 목차

- # 목차
	- [용어](#용어)
	- [수행 순서](#수행-순서)
	- [결합도](#결합도)
	- [빈](#빈)
	- [의존 주입](#의존-주입)
	- [어노테이션](#Annotation)
	- [계층](#계층)
	- [DB세팅](#데이터베이스-연결)
	- [참고 자료](#참고-자료)

## 용어

 1. IOC(제어의 역전) Inversion of Control
 2. DI(의존주입) Dependecy injection
     * 생성자 인젝션
     * setter 인젝션
     * 멤버변수 인젝션 
 3. AOP(공통관심사 OR 횡단관심사) Aspect Oriented Programming
 4. BEAN(강낭콩) 스프링에서 객체를 빈이라 부름

## 수행 순서
1. encoding 설정
  * window > prefer... > encoding 검색 > utf-8로 변경
  * xml 수정   
  	``` 
	<!-- 캐릭터 인코딩 필터 설정  -->
	<!-- 컨트롤러에서 response.setCharacterEncoding()를매번 실행하지 않기 위해 서블릿 필터를 이용해 처리  -->
	<filter>

		<filter-name>encodingFilter</filter-name>

		<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>

		<init-param>

			<param-name>encoding</param-name>

			<param-value>UTF-8</param-value>

		</init-param>

		<init-param>

			<param-name>forceEncoding</param-name>

			<param-value>true</param-value>

		</init-param>
	</filter>
	<filter-mapping>

		<filter-name>encodingFilter</filter-name>

		<url-pattern>/*</url-pattern>
	</filter-mapping>
	 <!-- jsp 파일 utf-8 페이지 인코딩 설정 <%@ page pageEncoding="UTF-8" %>  -->
	<jsp-config>

		<jsp-property-group>

			<url-pattern>*.jsp</url-pattern>

			<page-encoding>UTF-8</page-encoding>

		</jsp-property-group>
	</jsp-config>

  	```
2. 톰캣 서버 연동
3. pom.xml 버전 체크
	* 자바버전 1.8
	* 스프링프레임워크 5.0.7
	* junit 4.12
	* maven 플러그인 1.8
  
 4. maven 디펜던시 추가 안될때 Window - Preferences - Maven > 다운로드 관련 다 체크
 5. [db테스트를 위한 sql 생성](./src/main/resources/springbook.sql) 
  
 
 ## 결합도
 
 * [TVUser.java](./src/main/java/polymorphism/TVUser.java)
 

 ## 빈

1. 리소스 영역에 [application.xml](./src/main/resources/applicationContext.xml) 생성후 빈 추가

2. [TVUser](./src/main/java/polymorphism/TVUser.java) 파일에서 빈 팩토리 호출해서 사용 기본적으로 싱글톤 패턴으로 사용됨

* 번외: 싱글톤패턴 사용하기 싫을때 [application.xml](./src/main/resources/applicationContext.xml)
   `scope="prototype"` 스코프 속성을 사용해 바꿀수 있음


## 의존 주입
-----
1.생성자의 의한 주입.
```
<bean id="samsungTV" class="polymorphism.SamsungTV" ><!-- scope="prototype" -->
		<constructor-arg ref="apple"></constructor-arg>
		<constructor-arg value="270000"></constructor-arg>
</bean> 
```
-----

2.세터 메소드의 의한 주입
```
<bean id="samsungTV" class="polymorphism.SamsungTV" ><!-- scope="prototype" -->		
		<property name="speaker" ref="apple"></property>
		<property name="price" value="270000"></property>
</bean> 
```
-----
3.멤버변수의 의한 주입
#### 배열 (list,map,set,propertie ...)

#### List
```
<bean id="collectionBean"
		class="com.springbook.ioc.injection.CollectionBean">
		<property name="addressList">
			<list>
				<value>서울시 강남구</value>
				<value>서울시 영등포구</value>
			</list>
		</property>
</bean>
```

###### 값을 가져올때
```
AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
CollectionBean bean = (CollectionBean)factory.getBean("collectionBean");
List<String> addressList = bean.getAddressList();

for(String address : addressList) {
	System.out.println(address);
}

서울시 강남구
서울시 영등포구 반환
```
-----
#### Set
```
<bean id="collectionBean"
	class="com.springbook.ioc.injection.CollectionBean">
	<property name="addressList">
		<set value-type="java.lang.String">
			<value>서울시 강남구</value>
			<value>서울시 영등포구</value>
			<value>서울시 영등포구</value>
		</set>
	</property>
</bean>
```

##### 값을 가져올때
```
AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
CollectionBean bean = (CollectionBean)factory.getBean("collectionBean");
Set<String> addressList = bean.getAddressList();

for(String address : addressList) {
	System.out.println(address);
}
```
-----
#### Map
```
<bean id="collectionBean"
	class="com.springbook.ioc.injection.CollectionBean">
	<property name="addressList">
		<map>
			<entry>
				<key><value>고길동</value></key>
				<value>서울시 강남구</value>
			</entry>
			<entry>
				<key><value>홍길동</value></key>
				<value>서울시 영등포구</value>
			</entry>
		</map>
	</property>
</bean>
```

##### 값을 가져올때
```
AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

CollectionBean bean = (CollectionBean)factory.getBean("collectionBean");
Map<String,String> addressList = bean.getAddressList();

Iterator<String> keys = addressList.keySet().iterator();
while( keys.hasNext() ){
	String key = keys.next();
	System.out.println( String.format("키 : %s, 값 : %s", key, addressList.get(key)) );
}	

```
-----
#### Properties

```
<bean id="collectionBean"
	class="com.springbook.ioc.injection.CollectionBean">
	<property name="addressList">

		<props>
			<prop key="고길동">서울시 강남구</prop>
			<prop key="홍길동">서울시 영등포구</prop>
		</props>
	</property>
</bean>
```

##### 값을 가져올때
```
AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
CollectionBean bean = (CollectionBean)factory.getBean("collectionBean");
Properties addressList = bean.getAddressList();
for(String key : addressList.stringPropertyNames()) {
	System.out.println(String.format("키: %s / 값 : %s", key,addressList.get(key)));
}
```
-----

### Annotation

##### 빈 등록 어노테이션
> @Component
>
> ```
><context:component-scan base-package="패키지명(polymorphism)"></context:component-scan>
>--패키지명에 기입된 파일들을 빈으로 등록해준다.
>
>연결해줄 클래스 상단에 작성
>@Component("이름")
>
>사용할 클래스에서 불러와서 사용
>AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
>객체 name = (객체)factory.getBean("이름");
>
>```

##### 의존주입 어노테이션
> ##### @AutoWired
> 타입이 일치하는 빈을 찾아서 자동주입한다.
> 2개이상의 클래스가 존재할 경우 @Qualifier를 사용한다.
> @QualiFier("이름")
> ```
> @Autowired
> @Qualifier("apple")
> 
> **직접 개발한 클래스**는 어노테이션을 사용할수 있고, XML 설정을 할 수 있다.
> 하지만 **라이브러리 형태**로 제공되는 클래스는 반드시 XML설정을 통해서 사용해야 한다.(어노테이션 사용 불가)
----------

## 계층
> **Persentation(화면계층)** - 화면에 보여주는 기술을 사용하는 영역
> 
> **Business(비즈니스 계층)** - 고객이 원하는 요구사항을 반영하는 계층  
>  - VO, DAO, Service, Servicelmpl
>       
> **Persistence(영속계층 / 데이터 계층)** - 데이터를 어떤 방식으로 보관하고 사용하는가에 대한 설계가 들어가는 계층

---

## 데이터베이스 연결
>Build Path-> configure Build Path -> Library/Add External JARS -> 필요한JAR파일 열기 -> Deployment Assembly -> ADD -> JAVA Build Path Entries -> 파일추가하기
>

### oracle cloud 연결설정
```
public static Connection getConnection() {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(
			"jdbc:oracle:thin:@HYEONM1339_medium?TNS_ADMIN=[파일경로]",
				"admin", "[비밀번호]");
		System.out.println("DB 연결 완료");
		return conn;
	} catch (ClassNotFoundException e) {
		System.out.println("JDBC 드라이버 로드 에러");
	} catch (SQLException e) {
		System.out.println("DB연결 오류");
	}
	return null;
}
```

### DataBase close 메소드


```
>public static void close(PreparedStatement stmt, Connection conn) {
	if (stmt != null) {
		try {
			if (!stmt.isClosed())
				stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stmt = null;
		}
	}
	if (conn != null) {
		try {
			if (!conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}
}
public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
	if (rs != null) {
		try {
			if (!rs.isClosed())
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			rs = null;
		}
	}
	if (stmt != null) {
		try {
			if (!stmt.isClosed())
				stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stmt = null;
		}
	}
	if (conn != null) {
		try {
			if (!conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}
}
```


-----


### 참고 자료

* [의존성 주입 관련](https://codevang.tistory.com/312)
* [의존관계 쉽게 이해하기](https://tecoble.techcourse.co.kr/post/2021-04-27-dependency-injection/)
