package instutTask;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class RandomStudy {
    public static void main(String[] args) {
        Random random = new Random();
        HashMap<Integer, String> hashMap = new HashMap<>();

        while(true) {
            // 생성 (0~4)
            int i = 0;
            hashMap.put(i, "추상 팩토리(Abstract Factory)");
            i++;
            hashMap.put(i, "빌더(Builder)");
            i++;
            hashMap.put(i, "팩토리 메서드(Factory Method)");
            i++;
            hashMap.put(i, "프로토타입(Prototype)");
            i++;
            hashMap.put(i, "싱글톤(Singleton)");
            // 구조 (5~11)
            i++;
            hashMap.put(i, "어댑터(Adapter)");
            i++;
            hashMap.put(i, "브리지(Bridege)");
            i++;
            hashMap.put(i, "컴포지트(Composite)");
            i++;
            hashMap.put(i, "데코레이터(Decorator)");
            i++;
            hashMap.put(i, "퍼싸드(Facade)");
            i++;
            hashMap.put(i, "플라이웨이트(Flyweight)");
            i++;
            hashMap.put(i, "프록시(Proxy) ");
            // 행위 (12 ~ 22)
            i++;
            hashMap.put(i, "책임 연쇄(Chain of Responsibility)");
            i++;
            hashMap.put(i, "커맨드(Command)");
            i++;
            hashMap.put(i, "인터프리터(Interpreter)");
            i++;
            hashMap.put(i, "반복자(Iterator)");
            i++;
            hashMap.put(i, "중재자(Mediator)");
            i++;
            hashMap.put(i, "메멘토(Memento)");
            i++;
            hashMap.put(i, "옵서버(Observer)");
            i++;
            hashMap.put(i, "상태(State)");
            i++;
            hashMap.put(i, "전략(Strategy)");
            i++;
            hashMap.put(i, "템플릿 메소드(Template Method)");
            i++;
            hashMap.put(i, "방문자(Visitor)");

            Scanner scanner = new Scanner(System.in);
            int number = random.nextInt(23);

            System.out.println("다음 Gof(Gang of Four) 디자인 패턴중 알맞는 것은?(단답형)");
            System.out.println(hashMap.get(number));

            String result = "";
            String inputStr = scanner.next();

            if (number >= 0 && number < 5) result = "생성 생성패턴";
            else if (number > 4 && number < 13) result = "구조 구조패턴";
            else result = "행위 행위패턴";

            if (result.contains(inputStr)) System.out.println("정답");
            else System.out.println("오답"+" 정답은 : "+result);

            if(inputStr.contains("END")) break;
        }
    }
}
