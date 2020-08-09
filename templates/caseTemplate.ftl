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