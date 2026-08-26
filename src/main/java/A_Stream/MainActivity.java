package A_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MainActivity {
    public static void main(String[] args) {
        //collection(array, list . . .) -> stream me convert kar sakte hai -> declarative/functional
        // programming use kar sakte hai collections pe

        //in order to use map(), filter(), reduce().. then you need to convert collections into stream
        //map(function), filter(predicate)....

        int[] arr={1,2,3,4,5,6,7,8,9,0};
        int sum=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==0)
                sum+=arr[i];
        }
        System.out.println(sum);

        int sum2= Arrays.stream(arr).filter(n->n%2==0).sum();
        System.out.println(sum2);
        // readability, scalability, parallelism, Encapsulation

        List<String> list=Arrays.asList("apple","mango","grapes");
        Stream<String> stream = list.stream();

        String[] Arr={"abc","pqr","xyz"};
        Stream<String> stream1 = Arrays.stream(Arr);

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7);

        Stream<Integer> limit = Stream.iterate(0, n -> n + 1).limit(100);
//(seed, unary operator), seed - yaha se start karna h, har ek next elements ko create karne me iss unary operator(function)
        //ki help se hoga -> Stream.iterate(0,n->n+1); ye ek infinte loop hai so we limit it

        Stream<String> limit1 = Stream.generate(() -> "hello").limit(5);
        Stream<Integer> limit2 = Stream.generate(() -> (int)Math.random() * 100).limit(5);



    }
}
