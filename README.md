# javaSE-20-all-features

# Football
- Quick review of Lambda expression, stream

# Java 9

<img width="803" alt="reactive programming" src="https://github.com/lebronjamesuit/javaSE-20-all-features/assets/11584601/a57c393c-7be1-43ce-8c63-c820dcc55a0b">


# Java 11 
## 1) Compare the performance between HTTP/1_1 vs HTTP/2

HTTP/1.1 loads resources one after the other, so if one resource cannot be loaded, it blocks all the other resources behind it.


HTTP/2 is able to use a single TCP connection to send multiple streams of data at once so that no one resource blocks any other resource


<img width="1242" alt="Screenshot 2023-08-02 at 15 51 49" src="https://github.com/lebronjamesuit/javaSE-20-all-features/assets/11584601/9d1e8230-6c93-40fa-a91c-5a2c0b8c8fa3">

## 2) Local var in Lambda expression
Java 10 introduced type inference for local variables declared using 'var'. 

Java 11 extends this to allow 'var' to also be used on lambda parameters.

## Java 16

        // Java 11
        return  listLong.stream().map( l -> {
            return l.intValue();
        }).collect(toList());

        // Java 16: Stream has more direct APIs.
        return  listLong.stream().map( l -> {
            return l.intValue();
        }).toList();



