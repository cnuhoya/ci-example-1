/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * Practice Coding Team3
 * 201302387 김진혁
 * 201302491 최광호
 * 201302476 전성배
 * 201302467 이충완
 * 
 * */
package univ.lecture;

public class Application {
    public Calculator calculator(String[] args) {
        Calculator calc = new Calculator();
        String exp = args[0];

        int result = calc.calculate(exp);
        System.out.println(String.format("%s = %d", exp, result));

        return calc;
    }

	public static void main(String[] args) throws Exception {
        new Application().calculator(args);
	}
	

}
