package annotation_ex;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//커스텀 어노테이션
//@인터페이스
//JVM 실행시에 감지하게 하려면, @Retention(RetentionPolicy.RUNTIME
@Retention(RetentionPolicy.RUNTIME)
public @interface Count100 {

}
