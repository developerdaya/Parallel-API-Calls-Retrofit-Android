import 'dart:async';

void main() async {
  // Start a countdown timer with 1-second intervals for 15 seconds
  Timer.periodic(Duration(seconds: 1), (timer) {
    int remainingTime = 15 - timer.tick;
    print('Timer called: $remainingTime');

    if (timer.tick >= 15) {
      timer.cancel(); // Stop the timer after 15 seconds
      print('Timer finished');
    }
  });

  // First Future with a 10-second delay

  Future<String> firstFuture() async{
   return Future.delayed(Duration(seconds: 10), () {
      return 'called 1st method';
    });

  }


  // Second Future with a 4-second delay
  Future<String> secondFuture = Future.delayed(Duration(seconds: 4), () {
    return 'called 2nd method';
  });

  // Await the results of both futures
  String result1 = await firstFuture;
  print(result1); // "called 1st method"

  String result2 = await secondFuture;
  print(result2); // "called 2nd method"
}
