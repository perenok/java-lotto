# java-lotto
로또 미션 진행을 위한 저장소

## 기능 목록
#### 구입금액을 입력받는다.
 ```
  예외처리)
   - 숫자가 아닌 경우
   - 1000원 미만의 금액인 경우
   - 공백(null)인 경우
 ```

#### 수동으로 구매할 로또 수를 입력받는다.
 ```
  예외처리)
   - 숫자가 아닌 경우
   - 공백(null)인 경우
   - 입력받은 금액으로 구입 가능한 로또 수보다 큰 수를 입력받은 경우
 ```

#### 수동으로 구매할 로또의 번호를 입력받는다.

 - 로또 한장은 1000원이다.
 - 각 로또의 번호는 한 줄에 있는 6개의 숫자로 이루어진다.
 - 로또의 번호는 1~45의 숫자로 이루어져있다.
 - 로또의 번호는 오름차순으로 정렬되어있다.
 ```
  예외처리)
   - 숫자가 아닌 경우
   - 공백(null)인 경우
   - 입력받은 숫자의 개수가 6개보다 적은 경우
 ```

#### 구입금액에서 수동 발매를 제외하고 발급 가능한 매수 만큼 자동 발급한다.

 - 로또 한장은 1000원이다.
 - 각 로또의 번호는 랜덤으로 6개를 발급한다.
 - 로또의 번호는 1~45의 숫자로 이루어져있다.
 - 로또의 번호는 오름차순으로 정렬되어있다.
 ```
  예외처리)
    - 중복된 숫자가 하나의 로또에 발급된 경우
 ```

#### 발급한 로또들을 출력한다.

 - 각 로또는 []로 감싸져 있고, 번호는 쉼표+공백(,)으로 구분한다.
 - 수동으로 구매한 로또를 먼저 출력하고 나머지 자동으로 구매한 로또를 출력한다.

#### 지난주 당첨번호와 보너스 볼을 입력받는다.

 - 지난주 당첨번호 6개를 입력받는다.
 - 당첨 번호는 ", "으로 구분한다.
 - 보너스 볼은 하나의 숫자를 입력받는다
  ```
   예외처리)
     - 숫자가 아닌 경우
     - 로또 숫자가 아닌 경우
     - 공백(null)인 경우
     - 숫자가 중복된 경우
     - 보너스볼의 숫자가 당첨번호와 중복되는 경우
  ```

#### 당첨 통계와 수익률을 출력한다.

 - 구매한 로또들과 당첨번호를 비교해서 등수를 계산한다.
 - 당첨금액/구매금액으로 수익률을 계산한다.
 - 각 등수별 당첨된 로또 개수와 최종 수익률을 출력한다.



현재 수동 로또 생성에서 예외를 계속 돌리면 로또 생성이 제대로 안되는 버그가 있음