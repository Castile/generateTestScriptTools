package ${packageName};
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;


/**
* @author Hongliang Zhu
* @create ${createDateTime}
*/
public class ${fileName} {

<#list testCases as testCase>
    /**
    *<em>${testCase.caseDescription}</em>
    * @GIVEN ${testCase.GIVEN}
    * @WHEN ${testCase.WHEN}
    * @THEN ${testCase.THEN}
    */
    @Test
    public void should_${testCase.THEN}_given_${testCase.GIVEN}(){

    }


</#list>

}

