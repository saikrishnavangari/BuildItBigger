package com.example;

import java.util.Random;

public class JokeTeller {


    private static String jokeLIst[]= {
       "I dreamt I was forced to eat a giant marshmallow. When I woke up, my pillow was gone.\n",
       "My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away.\n",
       "When my wife starts to sing I always go out and do some garden work so our neighbors can see there\'s no domestic violence going on.\n",
       "Police officer: \"Can you identify yourself, sir?\"\n",
       "I canâ€™t believe I forgot to go to the gym today. Thatâ€™s 7 years in a row now.\n",
       "Woke up with a dead leg this morning. I will not take out a loan with the mafia ever again\n",
       "Iâ€™m selling my talking parrot. Why? Because yesterday, the bastard tried to sell me.\n",
       "Two Elephants meet a totally naked guy. After a while one elephant says to the other: \'I really donâ€™t get how he can feed himself with that thing!\'",
    };

    public static String getJokes() {

        int size = jokeLIst.length;
        Random r = new Random();
        int index = r.nextInt(size);
        return jokeLIst[index];
    }
}