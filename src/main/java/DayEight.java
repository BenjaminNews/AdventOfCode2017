import java.util.HashMap;

public class DayEight {

    private static String[] instructions;

    private HashMap<String, Integer> registerValues = new HashMap<String, Integer>();

    private Integer highestEverValue = Integer.MIN_VALUE;
    private int largestNumber = Integer.MIN_VALUE;


    public DayEight(String input) {
        instructions = input.split("\n");
        for(String values: instructions) {
            if(!registerValues.containsKey(values.split(" ")[0])) {
                registerValues.put(values.split(" ")[0], 0);
            }
        }
        executeInstructions();
    }

    private void executeInstructions() {
        for(String action : instructions) {
            String[] actionValues = action.split(" ");

            String assignmentKey = actionValues[0];

            String actionToPerform = actionValues[1];

            int actionValue = Integer.parseInt(actionValues[2]);

            String checkKeyForComparison = actionValues[4];

            String comparator = actionValues[5];

            int comparatorAgainstValue = Integer.parseInt(actionValues[6]);

            if(comparator.equalsIgnoreCase(">")) {
                performLargerThan(assignmentKey, actionToPerform, actionValue, checkKeyForComparison, comparatorAgainstValue);
            } else if(comparator.equalsIgnoreCase("<")) {
                performSmallerThan(assignmentKey, actionToPerform, actionValue, checkKeyForComparison, comparatorAgainstValue);
            } else if(comparator.equalsIgnoreCase(">=")) {
                performLargeThanOrEqualTo(assignmentKey, actionToPerform, actionValue, checkKeyForComparison, comparatorAgainstValue);
            } else if(comparator.equalsIgnoreCase("<=")) {
                performSmallerThanOrEqualTo(assignmentKey, actionToPerform, actionValue, checkKeyForComparison, comparatorAgainstValue);
            } else if(comparator.equalsIgnoreCase("==")) {
                performEqual(assignmentKey, actionToPerform, actionValue, checkKeyForComparison, comparatorAgainstValue);
            } else if(comparator.equalsIgnoreCase("!=")) {
                performNotEqual(assignmentKey, actionToPerform, actionValue, checkKeyForComparison, comparatorAgainstValue);
            } else {
                System.out.println("Huh?!?!");
            }

            if(registerValues.get(assignmentKey) > highestEverValue)
                highestEverValue = registerValues.get(assignmentKey);
        }
        getLargestEndingNumber();
    }

    private void getLargestEndingNumber() {
        for(String key : registerValues.keySet()) {
            if(registerValues.get(key) >  largestNumber) {
                largestNumber = registerValues.get(key);
            }
        }
    }

    public int getHighestEverValue() {
        return this.highestEverValue;
    }

    public int getLargestNumber() {
        return this.largestNumber;
    }

    private void performLargeThanOrEqualTo(String assignmentKey, String actionToPerform, int actionValue, String checkKeyForComparison, int comparatorAgainstValue) {
        if(registerValues.get(checkKeyForComparison) >= comparatorAgainstValue) {
            performIncrementOrDecrement(assignmentKey, actionToPerform, actionValue);
        }
    }

    private void decrementRegisterValue(String assignmentKey, int actionValue) {
        int initialValue = registerValues.get(assignmentKey);
        registerValues.put(assignmentKey, initialValue - actionValue);
    }

    private void incrementRegisterValue(String assignmentKey, int actionValue) {
        int initialValue = registerValues.get(assignmentKey);
        registerValues.put(assignmentKey, initialValue + actionValue);
    }

    private void performSmallerThanOrEqualTo(String assignmentKey, String actionToPerform, int actionValue, String checkKeyForComparison, int comparatorAgainstValue) {
        if(registerValues.get(checkKeyForComparison) <= comparatorAgainstValue) {
            performIncrementOrDecrement(assignmentKey, actionToPerform, actionValue);
        }
    }

    private void performSmallerThan(String assignmentKey, String actionToPerform, int actionValue, String checkKeyForComparison, int comparatorAgainstValue) {
        if(registerValues.get(checkKeyForComparison) < comparatorAgainstValue) {
            performIncrementOrDecrement(assignmentKey, actionToPerform, actionValue);
        }
    }

    private void performLargerThan(String assignmentKey, String actionToPerform, int actionValue, String checkKeyForComparison, int comparatorAgainstValue) {
        if(registerValues.get(checkKeyForComparison) > comparatorAgainstValue) {
            performIncrementOrDecrement(assignmentKey, actionToPerform, actionValue);
        }
    }

    private void performEqual(String assignmentKey, String actionToPerform, int actionValue, String checkKeyForComparison, int comparatorAgainstValue) {
        if(registerValues.get(checkKeyForComparison) == comparatorAgainstValue) {
            performIncrementOrDecrement(assignmentKey, actionToPerform, actionValue);
        }
    }

    private void performNotEqual(String assignmentKey, String actionToPerform, int actionValue, String checkKeyForComparison, int comparatorAgainstValue) {
        if(registerValues.get(checkKeyForComparison) != comparatorAgainstValue) {
            performIncrementOrDecrement(assignmentKey, actionToPerform, actionValue);
        }
    }

    private void performIncrementOrDecrement(String assignmentKey, String actionToPerform, int actionValue) {
        if (actionToPerform.equalsIgnoreCase("inc")) {
            incrementRegisterValue(assignmentKey, actionValue);
        } else if (actionToPerform.equalsIgnoreCase("dec")) {
            decrementRegisterValue(assignmentKey, actionValue);
        }
    }

    public static void main(String[] args) {
        DayEight dayEight = new DayEight(input);
        System.out.printf("Part one: %d%nPart two: %d%n", dayEight.getLargestNumber(), dayEight.getHighestEverValue());
    }

    private static final String input = "smi inc 781 if epx > -2\n" +
                                        "yrf dec -813 if jzm != 6\n" +
                                        "ben dec -383 if sp == 0\n" +
                                        "tlj dec -356 if sp <= 4\n" +
                                        "ssv dec -128 if tlj <= 360\n" +
                                        "vlh dec -978 if ih == 0\n" +
                                        "ben dec -28 if bwj > -5\n" +
                                        "w dec 216 if ben == 411\n" +
                                        "ke dec -540 if blg <= 9\n" +
                                        "ty dec 469 if yrf > 810\n" +
                                        "epx inc 203 if xo > -9\n" +
                                        "mlp inc -625 if blg != 10\n" +
                                        "sp dec -248 if epx == 203\n" +
                                        "xo inc 363 if oon >= -7\n" +
                                        "ke inc 188 if ih <= 9\n" +
                                        "smi dec -738 if smi == 781\n" +
                                        "epx inc 257 if ga >= 1\n" +
                                        "fdv inc 843 if rt >= -1\n" +
                                        "blg inc -99 if ssv == 128\n" +
                                        "oon dec 512 if vlh > 977\n" +
                                        "oon inc 233 if ben > 410\n" +
                                        "mx dec -577 if yrf >= 812\n" +
                                        "sp dec 919 if n <= 0\n" +
                                        "epx inc 639 if mx != 576\n" +
                                        "oon dec 628 if oon <= -271\n" +
                                        "sp dec 172 if rt > -4\n" +
                                        "b dec -207 if ty == -469\n" +
                                        "w inc -439 if ty <= -479\n" +
                                        "bwj dec 533 if sp >= -844\n" +
                                        "sp inc -882 if jzm == 0\n" +
                                        "ih inc -377 if b >= 199\n" +
                                        "k dec 546 if tlj <= 364\n" +
                                        "oon inc -617 if ih != -373\n" +
                                        "yrf dec -400 if fdv > 840\n" +
                                        "bwj dec -254 if ssv <= 134\n" +
                                        "ssv dec -314 if tlj >= 351\n" +
                                        "smi dec 725 if blg <= -93\n" +
                                        "oon inc 485 if rt < 4\n" +
                                        "jzm inc 498 if xo == 363\n" +
                                        "yrf dec -391 if b < 216\n" +
                                        "epx inc -282 if ssv == 442\n" +
                                        "tlj dec 840 if jzm < 505\n" +
                                        "mlp dec -632 if jzm < 504\n" +
                                        "ssv dec -440 if b <= 207\n" +
                                        "blg dec -499 if tlj <= -482\n" +
                                        "xo dec 734 if xo == 363\n" +
                                        "ben dec -553 if rt == 0\n" +
                                        "smi inc 41 if mx >= 574\n" +
                                        "w dec -995 if ke < 738\n" +
                                        "xo dec -465 if w < 774\n" +
                                        "sp dec 339 if smi == 835\n" +
                                        "mx dec -38 if rt > -4\n" +
                                        "ben inc -448 if blg >= 401\n" +
                                        "oon inc 272 if w > 770\n" +
                                        "mx inc -805 if ga < 4\n" +
                                        "sp dec 853 if epx == 560\n" +
                                        "fdv inc 165 if fdv > 838\n" +
                                        "yrf inc -605 if blg > 399\n" +
                                        "tlj dec 533 if bwj < -271\n" +
                                        "smi dec 915 if ben > 954\n" +
                                        "oon dec 864 if ben != 964\n" +
                                        "ssv dec -111 if yrf < 990\n" +
                                        "sp inc 401 if jzm != 497\n" +
                                        "xo dec -434 if tlj != -1017\n" +
                                        "vlh dec 650 if fdv < 1000\n" +
                                        "ssv inc -570 if rt < 6\n" +
                                        "fdv inc -788 if mlp <= 14\n" +
                                        "oon dec -121 if ssv > 319\n" +
                                        "ben dec 905 if k == -546\n" +
                                        "tlj inc 853 if bwj < -274\n" +
                                        "vlh dec -680 if b != 201\n" +
                                        "rt dec 661 if bwj != -276\n" +
                                        "epx dec -515 if ssv > 318\n" +
                                        "rt inc -214 if ih <= -372\n" +
                                        "k dec 827 if ben < 67\n" +
                                        "ih dec -708 if sp != -2525\n" +
                                        "w dec -616 if epx == 560\n" +
                                        "b dec -455 if b >= 207\n" +
                                        "sp dec -619 if vlh > 1662\n" +
                                        "bwj dec -645 if ssv >= 305\n" +
                                        "n dec -276 if ke <= 731\n" +
                                        "w inc -426 if epx >= 566\n" +
                                        "k inc 848 if rt > -881\n" +
                                        "mx inc -952 if fdv > 219\n" +
                                        "ga dec 423 if mx > -1143\n" +
                                        "w inc 37 if bwj <= 373\n" +
                                        "jzm inc -800 if ben >= 56\n" +
                                        "xo inc -954 if xo >= -368\n" +
                                        "n inc -778 if jzm < -292\n" +
                                        "w inc 356 if tlj > -165\n" +
                                        "ty dec 913 if w > 1779\n" +
                                        "rt inc -810 if ke != 731\n" +
                                        "ke inc -838 if ssv <= 313\n" +
                                        "oon dec -839 if mx < -1139\n" +
                                        "xo dec 921 if jzm > -310\n" +
                                        "b dec 381 if jzm < -292\n" +
                                        "oon dec 273 if ssv <= 314\n" +
                                        "blg dec -524 if ga <= -415\n" +
                                        "ga inc 9 if rt >= -1694\n" +
                                        "rt dec -133 if smi <= -79\n" +
                                        "blg dec -518 if yrf >= 997\n" +
                                        "xo inc 718 if jzm >= -309\n" +
                                        "w inc -224 if smi != -77\n" +
                                        "epx dec 734 if n >= -502\n" +
                                        "ssv inc 770 if ben < 60\n" +
                                        "fdv inc 203 if ih <= 332\n" +
                                        "w dec -693 if tlj <= -162\n" +
                                        "rt inc 789 if smi <= -75\n" +
                                        "mx inc -359 if bwj >= 359\n" +
                                        "ty dec 178 if mlp != 3\n" +
                                        "ty dec -539 if k >= -532\n" +
                                        "w inc 769 if tlj == -164\n" +
                                        "k inc 91 if n == -502\n" +
                                        "bwj inc 730 if jzm == -302\n" +
                                        "ssv inc -895 if vlh == 1658\n" +
                                        "rt inc -440 if ih >= 340\n" +
                                        "bwj inc -38 if smi > -89\n" +
                                        "sp inc 718 if w == 3026\n" +
                                        "oon dec -533 if yrf < 1009\n" +
                                        "tlj dec -944 if xo == -574\n" +
                                        "vlh inc -608 if b > 277\n" +
                                        "ssv inc -88 if sp >= -1799\n" +
                                        "vlh dec -493 if bwj <= 1067\n" +
                                        "b inc 676 if ga <= -420\n" +
                                        "bwj inc 676 if k == -434\n" +
                                        "blg inc -240 if mlp <= 10\n" +
                                        "b dec 130 if xo > -580\n" +
                                        "blg dec -363 if k > -441\n" +
                                        "ty dec 903 if bwj >= 1743\n" +
                                        "ga dec -499 if fdv == 423\n" +
                                        "bwj dec -500 if ty > -1022\n" +
                                        "n inc -250 if jzm <= -308\n" +
                                        "jzm dec 3 if fdv == 423\n" +
                                        "epx dec -930 if n == -499\n" +
                                        "b dec 614 if bwj != 2234\n" +
                                        "blg inc -908 if n >= -502\n" +
                                        "ty dec -309 if oon <= 332\n" +
                                        "b dec -611 if ssv <= 107\n" +
                                        "yrf dec -707 if vlh > 1536\n" +
                                        "tlj inc 734 if b <= 756\n" +
                                        "smi dec -75 if jzm >= -306\n" +
                                        "n dec -390 if fdv >= 416\n" +
                                        "vlh dec 950 if sp >= -1788\n" +
                                        "oon dec -95 if ben >= 67\n" +
                                        "jzm inc -22 if epx == -174\n" +
                                        "epx dec 442 if jzm >= -331\n" +
                                        "ty inc -583 if sp >= -1798\n" +
                                        "mx inc -744 if vlh >= 1534\n" +
                                        "w dec -142 if ke > -101\n" +
                                        "ty dec -535 if bwj < 2243\n" +
                                        "xo dec 190 if n > -117\n" +
                                        "smi inc 358 if k == -434\n" +
                                        "vlh inc 321 if mlp >= 9\n" +
                                        "mx inc 325 if epx == -611\n" +
                                        "ke dec -631 if oon == 334\n" +
                                        "vlh dec 798 if k <= -427\n" +
                                        "w dec 183 if bwj > 2224\n" +
                                        "ssv dec -506 if fdv >= 432\n" +
                                        "fdv inc 125 if ssv == 99\n" +
                                        "epx inc -465 if vlh <= 754\n" +
                                        "ga dec 108 if mlp != 1\n" +
                                        "jzm dec -623 if oon == 332\n" +
                                        "ben inc -400 if vlh < 753\n" +
                                        "sp inc 157 if bwj < 2236\n" +
                                        "fdv dec -4 if xo == -774\n" +
                                        "mx dec -590 if ben > -347\n" +
                                        "ssv inc -542 if b <= 766\n" +
                                        "epx dec -189 if rt >= -766\n" +
                                        "ben dec 819 if ben >= -347\n" +
                                        "sp inc -194 if n < -116\n" +
                                        "n dec 755 if mlp != 16\n" +
                                        "ih dec -49 if mx < -1646\n" +
                                        "tlj inc 653 if ben <= -1160\n" +
                                        "ben inc 574 if n >= -873\n" +
                                        "fdv dec 346 if k != -427\n" +
                                        "ke inc -49 if blg == 657\n" +
                                        "epx inc -322 if bwj >= 2230\n" +
                                        "epx dec -984 if vlh >= 741\n" +
                                        "smi dec -486 if w <= 2846\n" +
                                        "mlp inc 992 if blg != 667\n" +
                                        "jzm dec 532 if bwj <= 2234\n" +
                                        "jzm dec 600 if sp == -1641\n" +
                                        "xo inc -795 if tlj < 1437\n" +
                                        "ben dec -93 if ke == -159\n" +
                                        "sp inc -226 if epx < -222\n" +
                                        "n dec 333 if b != 771\n" +
                                        "smi dec -731 if tlj != 1426\n" +
                                        "k dec 654 if jzm < -827\n" +
                                        "tlj dec -167 if ty == -760\n" +
                                        "n inc -905 if ga >= -32\n" +
                                        "w dec -561 if sp != -1864\n" +
                                        "b dec 710 if mlp >= 1002\n" +
                                        "ke dec 957 if tlj >= 1599\n" +
                                        "sp inc -272 if rt <= -754\n" +
                                        "blg inc -247 if oon == 332\n" +
                                        "ty inc 846 if mx < -1646\n" +
                                        "mlp inc -678 if bwj == 2234\n" +
                                        "vlh dec 254 if bwj == 2228\n" +
                                        "yrf inc 500 if ih == 380\n" +
                                        "mx inc 740 if blg > 401\n" +
                                        "yrf dec 692 if bwj == 2234\n" +
                                        "ke inc 949 if n == -2098\n" +
                                        "n dec 492 if fdv <= 209\n" +
                                        "ssv dec 335 if blg < 411\n" +
                                        "mx inc 835 if blg < 403\n" +
                                        "bwj dec -565 if w == 3404\n" +
                                        "tlj inc 465 if ga <= -16\n" +
                                        "oon inc 494 if ga == -23\n" +
                                        "blg dec -270 if b >= 766\n" +
                                        "n dec -816 if xo != -1567\n" +
                                        "mx inc -519 if oon != 818\n" +
                                        "ga dec 752 if rt == -771\n" +
                                        "ty dec -882 if mx < -1432\n" +
                                        "ga inc -341 if ben < -490\n" +
                                        "ga dec 680 if bwj != 2807\n" +
                                        "tlj inc -729 if xo == -1559\n" +
                                        "rt dec -353 if ben <= -495\n" +
                                        "tlj inc 949 if ty != 968\n" +
                                        "k dec -674 if sp > -2131\n" +
                                        "bwj dec -331 if vlh != 735\n" +
                                        "ssv inc 736 if bwj < 3135\n" +
                                        "rt dec 701 if n > -1786\n" +
                                        "xo dec -284 if ke <= -1115\n" +
                                        "oon dec 406 if yrf >= 1514\n" +
                                        "ih inc 144 if ty > 968\n" +
                                        "oon dec 287 if b != 756\n" +
                                        "ssv dec 588 if mx == -1434\n" +
                                        "tlj inc -217 if rt >= -1465\n" +
                                        "k dec -367 if yrf == 1514\n" +
                                        "ke dec 475 if ke <= -1114\n" +
                                        "k inc 572 if jzm == -843\n" +
                                        "epx inc -878 if vlh != 750\n" +
                                        "xo inc 889 if bwj >= 3139\n" +
                                        "n inc -159 if oon <= 139\n" +
                                        "ty dec 961 if vlh == 745\n" +
                                        "bwj dec 761 if w != 3404\n" +
                                        "mlp inc -543 if n != -1936\n" +
                                        "tlj inc -929 if blg != 410\n" +
                                        "mx inc 752 if ty <= 12\n" +
                                        "ke dec -473 if jzm == -836\n" +
                                        "n inc -250 if ih < 385\n" +
                                        "ty dec -995 if jzm < -834\n" +
                                        "jzm inc -367 if epx >= -1100\n" +
                                        "mlp dec -587 if xo > -1281\n" +
                                        "xo inc -297 if fdv >= 204\n" +
                                        "ben dec -791 if blg == 410\n" +
                                        "ty inc 448 if mx < -678\n" +
                                        "vlh inc -658 if sp == -2139\n" +
                                        "blg inc -936 if mx >= -676\n" +
                                        "xo inc -968 if sp == -2139\n" +
                                        "rt inc 239 if rt <= -1456\n" +
                                        "epx inc -910 if mlp != 366\n" +
                                        "ben inc -509 if vlh == 87\n" +
                                        "ben dec -936 if b >= 755\n" +
                                        "tlj dec 410 if bwj > 3122\n" +
                                        "mx inc -154 if ga >= -1049\n" +
                                        "bwj inc -470 if ga >= -1046\n" +
                                        "bwj dec -753 if b > 754\n" +
                                        "ga dec -150 if tlj <= 709\n" +
                                        "ssv dec 596 if mx <= -827\n" +
                                        "ke inc -698 if n != -2191\n" +
                                        "rt dec 554 if ih <= 386\n" +
                                        "ga inc 630 if jzm >= -837\n" +
                                        "ben dec -127 if ty <= 1452\n" +
                                        "fdv dec 564 if sp < -2137\n" +
                                        "fdv inc -687 if ih >= 389\n" +
                                        "mx dec 834 if sp >= -2140\n" +
                                        "rt inc 503 if w <= 3407\n" +
                                        "fdv inc -652 if ben != 852\n" +
                                        "ben dec 981 if rt > -1278\n" +
                                        "sp inc -396 if bwj < 3421\n" +
                                        "fdv dec -510 if sp != -2535\n" +
                                        "w inc 279 if w >= 3399\n" +
                                        "bwj inc 480 if n != -2199\n" +
                                        "n dec -430 if ke >= -1821\n" +
                                        "mx inc -153 if rt > -1282\n" +
                                        "oon inc -452 if blg <= 414\n" +
                                        "ke dec 956 if sp < -2525\n" +
                                        "bwj inc 533 if rt < -1280\n" +
                                        "ga inc -844 if ssv >= -1222\n" +
                                        "rt inc -872 if jzm < -841\n" +
                                        "k dec -439 if ih >= 373\n" +
                                        "ih dec 315 if n >= -1758\n" +
                                        "b dec -381 if ke <= -2779\n" +
                                        "tlj inc 149 if ty <= 1455\n" +
                                        "vlh dec 672 if k >= -285\n" +
                                        "ga inc -816 if fdv > -360\n" +
                                        "mlp inc -187 if ty > 1444\n" +
                                        "mx inc 265 if ssv <= -1223\n" +
                                        "tlj inc 229 if ga < -258\n" +
                                        "w inc 138 if smi <= 1563\n" +
                                        "bwj dec -707 if xo != -2245\n" +
                                        "blg dec 555 if vlh > -590\n" +
                                        "smi dec -930 if smi >= 1570\n" +
                                        "vlh dec 345 if sp > -2536\n" +
                                        "ben inc -558 if n >= -1769\n" +
                                        "ty dec -905 if b == 761\n" +
                                        "rt inc 98 if ty <= 1447\n" +
                                        "ga dec -141 if k > -288\n" +
                                        "oon dec 400 if mx >= -1565\n" +
                                        "k inc -409 if mx > -1564\n" +
                                        "tlj dec -370 if smi <= 2493\n" +
                                        "yrf inc -933 if n > -1752\n" +
                                        "fdv dec -476 if k <= -688\n" +
                                        "blg dec -686 if k <= -688\n" +
                                        "rt inc -121 if smi != 2504\n" +
                                        "k inc 747 if smi >= 2492\n" +
                                        "k dec 341 if smi >= 2510\n" +
                                        "w inc 658 if sp <= -2532\n" +
                                        "oon inc 890 if ty > 1444\n" +
                                        "mx inc 790 if tlj != 1087\n" +
                                        "smi dec 719 if smi <= 2501\n" +
                                        "n inc -454 if bwj != 4600\n" +
                                        "n inc 321 if ke == -2772\n" +
                                        "smi inc 370 if tlj == 1078\n" +
                                        "ty dec 1 if mx > -1568\n" +
                                        "w inc -535 if blg <= 550\n" +
                                        "vlh dec -306 if jzm >= -843\n" +
                                        "yrf dec 529 if n != -1433\n" +
                                        "vlh dec 357 if mx != -1558\n" +
                                        "k dec 392 if ih >= 386\n" +
                                        "ssv inc -875 if k != 56\n" +
                                        "w inc -879 if w > 3800\n" +
                                        "rt dec 927 if ssv <= -1219\n" +
                                        "smi dec 649 if n == -1439\n" +
                                        "rt inc 752 if ih < 387\n" +
                                        "ben inc 612 if fdv == 112\n" +
                                        "n inc 802 if fdv == 118\n" +
                                        "tlj dec -175 if oon != 169\n" +
                                        "k inc -500 if tlj < 1255\n" +
                                        "k dec 852 if ih != 377\n" +
                                        "ih dec -107 if fdv <= 110\n" +
                                        "oon dec -569 if ga != -114\n" +
                                        "ssv inc 574 if ssv == -1226\n" +
                                        "blg inc 728 if yrf != 993\n" +
                                        "yrf inc -921 if vlh <= -619\n" +
                                        "jzm dec -870 if sp >= -2542\n" +
                                        "mlp inc 186 if blg < 1279\n" +
                                        "ih inc 283 if epx <= -2013\n" +
                                        "bwj dec 890 if ty == 1449\n" +
                                        "n inc -249 if mx < -1551\n" +
                                        "smi inc 102 if k != -787\n" +
                                        "sp inc 682 if bwj > 3706\n" +
                                        "ty inc 427 if ih != 661\n" +
                                        "fdv dec -721 if xo != -2243\n" +
                                        "rt dec 886 if ga <= -131\n" +
                                        "ty inc 463 if ke <= -2771\n" +
                                        "vlh dec -61 if bwj == 3710\n" +
                                        "rt inc 773 if ben >= -690\n" +
                                        "k inc -659 if mlp != 369\n" +
                                        "ssv inc 562 if b == 762\n" +
                                        "ssv inc 584 if ke < -2767\n" +
                                        "ke inc 989 if smi <= 1243\n" +
                                        "ty inc 319 if ke > -1793\n" +
                                        "xo inc 540 if oon <= 746\n" +
                                        "rt dec 763 if sp >= -1859\n" +
                                        "smi inc -363 if b >= 759\n" +
                                        "vlh dec -740 if w < 2933\n" +
                                        "ben inc -590 if rt != -1571\n" +
                                        "ty inc 349 if sp < -1848\n" +
                                        "mlp inc -330 if oon <= 731\n" +
                                        "yrf dec 389 if vlh == 177\n" +
                                        "smi dec -983 if ben != -1275\n" +
                                        "xo dec 282 if w > 2929\n" +
                                        "bwj dec -605 if oon != 749\n" +
                                        "k inc 433 if blg != 1272\n" +
                                        "sp inc -504 if ben == -1277\n" +
                                        "ke dec 274 if mx >= -1560\n" +
                                        "mlp inc -638 if w == 2927\n" +
                                        "mx inc -15 if smi > 1860\n" +
                                        "w inc -91 if ty > 3002\n" +
                                        "rt dec 64 if tlj < 1264\n" +
                                        "smi inc 994 if ben > -1274\n" +
                                        "w dec -442 if bwj >= 4310\n" +
                                        "ty dec -777 if ty <= 3014\n" +
                                        "jzm inc -394 if epx >= -2026\n" +
                                        "fdv inc -909 if epx == -2018\n" +
                                        "smi dec 255 if sp <= -2355\n" +
                                        "vlh inc 591 if fdv <= -795\n" +
                                        "ben inc 384 if vlh >= 761\n" +
                                        "tlj inc -479 if yrf == -330\n" +
                                        "ssv inc -179 if epx == -2018\n" +
                                        "ke dec 984 if fdv < -791\n" +
                                        "ben inc 570 if b > 768\n" +
                                        "ty dec -231 if mx < -1557\n" +
                                        "vlh dec 844 if rt != -1616\n" +
                                        "smi inc 932 if rt == -1626\n" +
                                        "ih dec -609 if fdv == -795\n" +
                                        "ga inc -774 if bwj == 4315\n" +
                                        "fdv inc 640 if bwj == 4315\n" +
                                        "w inc 132 if n >= -1697\n" +
                                        "ssv inc -957 if rt == -1626\n" +
                                        "ty dec -205 if fdv <= -153\n" +
                                        "fdv inc 32 if bwj <= 4320\n" +
                                        "vlh dec 960 if vlh >= -82\n" +
                                        "tlj dec 658 if oon == 740\n" +
                                        "k inc 654 if ke >= -3033\n" +
                                        "vlh dec -562 if vlh > -1043\n" +
                                        "sp inc 308 if w > 3405\n" +
                                        "oon inc -795 if smi >= 2522\n" +
                                        "ssv dec -728 if epx == -2018\n" +
                                        "sp dec 843 if bwj != 4325\n" +
                                        "k inc -745 if ga >= -891\n" +
                                        "n inc -767 if yrf < -329\n" +
                                        "vlh inc 323 if mx < -1554\n" +
                                        "ga inc 513 if bwj == 4315\n" +
                                        "xo inc -419 if ga != -384\n" +
                                        "b dec 5 if ga != -374\n" +
                                        "ga inc -651 if xo > -1705\n" +
                                        "k inc 266 if ke > -3042\n" +
                                        "tlj inc 172 if b > 757\n" +
                                        "ke dec -916 if smi >= 2539\n" +
                                        "w inc 262 if n <= -1681\n" +
                                        "n dec -154 if ssv < 80\n" +
                                        "yrf inc 243 if ga < -1044\n" +
                                        "rt dec 523 if b < 757\n" +
                                        "ben inc 383 if sp < -2882\n" +
                                        "k inc -987 if vlh < -149\n" +
                                        "oon inc 676 if ben <= -508\n" +
                                        "mlp inc 782 if ga < -1033\n" +
                                        "fdv inc 687 if jzm > -353\n" +
                                        "rt dec -746 if n == -1688\n" +
                                        "w dec -358 if smi <= 2537\n" +
                                        "jzm inc -365 if k > -1745\n" +
                                        "smi dec 978 if rt != -888\n" +
                                        "tlj inc 294 if mx >= -1562\n" +
                                        "yrf inc 215 if vlh == -144\n" +
                                        "smi dec 732 if xo < -1693\n" +
                                        "rt inc -533 if yrf > -332\n" +
                                        "sp dec -348 if ga <= -1030\n" +
                                        "ga inc -374 if ih < 1282\n" +
                                        "ga inc -362 if ke < -3048\n" +
                                        "b inc -404 if ty > 4214\n" +
                                        "blg inc -702 if ke <= -3047\n" +
                                        "rt dec -868 if ben != -510\n" +
                                        "ben inc 412 if blg >= 1268\n" +
                                        "ssv dec 888 if ssv <= 81\n" +
                                        "w inc 850 if tlj != 898\n" +
                                        "w inc 697 if oon > 619\n" +
                                        "ih inc 885 if w >= 4718\n" +
                                        "yrf dec 778 if k != -1749\n" +
                                        "b dec -155 if b > 344\n" +
                                        "epx dec -49 if ga <= -1403\n" +
                                        "ty dec 683 if ih == 2162\n" +
                                        "n inc 127 if blg != 1267\n" +
                                        "w dec -640 if ty < 4229\n" +
                                        "ty dec 798 if blg == 1269\n" +
                                        "blg dec 197 if k != -1739\n" +
                                        "ga inc 803 if ben == -100\n" +
                                        "mlp dec 230 if bwj != 4315\n" +
                                        "mx inc -560 if smi >= 818\n" +
                                        "ga inc 629 if fdv > -128\n" +
                                        "smi dec -585 if ben >= -106\n" +
                                        "vlh dec -145 if epx >= -1976\n" +
                                        "ty inc 654 if tlj >= 908\n" +
                                        "yrf dec 775 if bwj < 4319\n" +
                                        "sp inc 364 if oon > 630\n" +
                                        "ke inc 152 if ga >= -774\n" +
                                        "ke inc 430 if ih == 2157\n" +
                                        "epx inc -137 if k == -1743\n" +
                                        "w dec -429 if k != -1738\n" +
                                        "smi dec 306 if n >= -1561\n" +
                                        "ga inc -495 if ke < -2606\n" +
                                        "w dec 364 if mlp != 511\n" +
                                        "smi dec -994 if n >= -1570\n" +
                                        "epx dec 440 if ssv >= 84\n" +
                                        "epx inc 197 if oon == 623\n" +
                                        "sp dec 378 if ssv != 81\n" +
                                        "jzm inc 633 if w != 5432\n" +
                                        "oon dec 824 if blg < 1074\n" +
                                        "tlj dec 927 if ty <= 3425\n" +
                                        "b dec -240 if xo < -1697\n" +
                                        "yrf inc 916 if rt <= -1413\n" +
                                        "mlp inc 51 if oon != -212\n" +
                                        "xo inc -509 if b < 754\n" +
                                        "mx inc 498 if bwj != 4319\n" +
                                        "ty inc -682 if ben != -91\n" +
                                        "oon inc -498 if mlp == 559\n" +
                                        "bwj dec -46 if ih < 2155\n" +
                                        "bwj dec -133 if ga != -1278\n" +
                                        "smi dec 678 if oon < -700\n" +
                                        "ih inc -775 if mx < -1614\n" +
                                        "mx inc -312 if fdv != -114\n" +
                                        "xo dec -931 if fdv > -133\n" +
                                        "sp dec 623 if ben <= -96\n" +
                                        "blg dec -602 if epx <= -2541\n" +
                                        "vlh inc 709 if ssv != 86\n" +
                                        "k inc 23 if yrf >= -953\n" +
                                        "rt inc 955 if fdv > -127\n" +
                                        "blg inc -971 if jzm < -719\n" +
                                        "ty dec 500 if blg <= 707\n" +
                                        "rt inc 905 if epx < -2550\n" +
                                        "w inc -648 if b == 748\n" +
                                        "n inc 417 if vlh > -1\n" +
                                        "sp inc 132 if ben == -98\n" +
                                        "ben inc -18 if fdv <= -119\n" +
                                        "xo inc 911 if n < -1552\n" +
                                        "vlh dec -719 if n < -1555\n" +
                                        "fdv dec -284 if vlh < 719\n" +
                                        "ben dec -849 if smi == 1426\n" +
                                        "ty inc -188 if w > 4781\n" +
                                        "epx dec -569 if blg == 703\n" +
                                        "mx inc 128 if epx >= -1985\n" +
                                        "ty inc 929 if ty != 2048\n" +
                                        "ga dec -602 if mlp == 559\n" +
                                        "yrf inc 280 if ty < 2984\n" +
                                        "w inc 180 if rt == -458\n" +
                                        "ben dec -664 if xo == -370\n" +
                                        "mlp dec -495 if fdv <= 165\n" +
                                        "ben dec -292 if w <= 4965\n" +
                                        "xo dec 335 if tlj < -24\n" +
                                        "ga inc -778 if ssv == 86\n" +
                                        "vlh inc -915 if ty == 2981\n" +
                                        "sp inc 665 if vlh < -208\n" +
                                        "jzm dec 961 if smi > 1415\n" +
                                        "b dec -160 if ke > -2612\n" +
                                        "ga dec 665 if n != -1565\n" +
                                        "xo dec 813 if ssv == 93\n" +
                                        "epx dec 642 if mx != -1805\n" +
                                        "ben dec 199 if ke >= -2611\n" +
                                        "ke dec -517 if blg != 710\n" +
                                        "ga inc -788 if smi != 1408\n" +
                                        "ben inc -201 if bwj != 4450\n" +
                                        "rt inc 893 if smi > 1411\n" +
                                        "n inc -659 if blg == 703\n" +
                                        "blg dec -92 if bwj <= 4449\n" +
                                        "k dec -949 if bwj == 4448\n" +
                                        "ssv inc -540 if ssv != 93\n" +
                                        "tlj inc 116 if b == 908\n" +
                                        "rt dec -587 if ty >= 2977\n" +
                                        "sp inc 94 if jzm != -1681\n" +
                                        "oon dec 985 if ga >= -2904\n" +
                                        "n inc -2 if blg <= 802\n" +
                                        "epx dec -263 if blg < 802\n" +
                                        "ih dec -394 if ty != 2978\n" +
                                        "oon dec 979 if b >= 901\n" +
                                        "tlj inc 687 if vlh < -198\n" +
                                        "ty dec 152 if fdv != 153\n" +
                                        "oon dec 848 if ben == 440\n" +
                                        "ty dec -596 if blg <= 792\n" +
                                        "fdv dec -391 if tlj != 783\n" +
                                        "n dec -148 if ty < 2839\n" +
                                        "ke inc -333 if w <= 4964\n" +
                                        "mlp inc -174 if ga <= -2895\n" +
                                        "rt inc 11 if tlj != 784\n" +
                                        "ty dec 610 if ben < 444\n" +
                                        "ben inc -901 if oon != -3513\n" +
                                        "sp dec 484 if blg >= 793\n" +
                                        "mlp dec 131 if epx == -2356\n" +
                                        "mx dec -973 if yrf < -675\n" +
                                        "n inc -455 if ih != 1779\n" +
                                        "blg inc 696 if sp != -3793\n" +
                                        "k inc -780 if w < 4967\n" +
                                        "b inc 783 if jzm >= -1680\n" +
                                        "sp dec -17 if oon < -3509\n" +
                                        "b inc 418 if b != 902\n" +
                                        "jzm dec -116 if ga != -2895\n" +
                                        "ben dec -26 if epx > -2355\n" +
                                        "jzm inc -116 if blg < 1498\n" +
                                        "smi inc -137 if mlp == 739\n" +
                                        "n inc 521 if epx != -2353\n" +
                                        "vlh inc 889 if ty == 2219\n" +
                                        "epx inc -454 if yrf == -682\n" +
                                        "tlj dec -154 if vlh < 680\n" +
                                        "n dec 585 if oon <= -3508\n" +
                                        "xo inc 401 if mx > -824\n" +
                                        "ke dec 368 if mlp != 739\n" +
                                        "blg dec -737 if mlp <= 751\n" +
                                        "fdv dec -935 if mlp <= 741\n" +
                                        "tlj dec -666 if sp != -3788\n" +
                                        "rt dec -519 if w >= 4960\n" +
                                        "smi dec -598 if epx == -2810\n" +
                                        "ben dec -16 if ke >= -2789\n" +
                                        "rt dec -844 if yrf < -680\n" +
                                        "oon dec -945 if yrf < -673\n" +
                                        "sp dec -101 if vlh > 685\n" +
                                        "xo inc -737 if ke >= -2797\n" +
                                        "fdv inc 346 if smi == 2014\n" +
                                        "ssv dec -261 if tlj != 1441\n" +
                                        "ga dec -176 if sp != -3685\n" +
                                        "fdv dec 737 if mx > -838\n" +
                                        "smi inc 842 if k >= -1581\n" +
                                        "blg inc -939 if bwj <= 4452\n" +
                                        "rt inc 415 if xo >= -1448\n" +
                                        "b dec -207 if xo > -1445\n" +
                                        "tlj dec -923 if jzm <= -1678\n" +
                                        "yrf dec -814 if ssv > -196\n" +
                                        "jzm dec 845 if sp > -3688\n" +
                                        "rt inc 594 if b < 1534\n" +
                                        "ty inc 185 if mlp < 757\n" +
                                        "b inc 220 if xo >= -1448\n" +
                                        "mx inc 464 if w < 4971\n" +
                                        "fdv dec -627 if n >= -2590\n" +
                                        "tlj inc 904 if bwj == 4448\n" +
                                        "n dec -37 if mlp > 757\n" +
                                        "fdv inc -157 if k <= -1568\n" +
                                        "rt inc 709 if ty >= 2400\n" +
                                        "mx dec -716 if epx <= -2807\n" +
                                        "sp inc -861 if vlh != 697\n" +
                                        "mlp dec -812 if ssv < -188\n" +
                                        "ke inc 95 if jzm < -2532\n" +
                                        "k inc -115 if ssv >= -197\n" +
                                        "mlp dec 489 if smi <= 2859\n" +
                                        "mx dec -424 if ty <= 2396\n" +
                                        "ty inc 474 if sp == -4543\n" +
                                        "blg dec -161 if epx > -2820\n" +
                                        "b inc 23 if n == -2593\n" +
                                        "bwj inc -119 if fdv == 4\n" +
                                        "fdv dec 210 if rt <= 4118\n" +
                                        "k dec -539 if smi == 2856\n" +
                                        "jzm dec 592 if mlp < 1079\n" +
                                        "tlj inc 886 if vlh < 680\n" +
                                        "oon dec 940 if k >= -1154\n" +
                                        "blg dec 426 if k < -1147\n" +
                                        "k dec 438 if ssv < -192\n" +
                                        "ssv inc -937 if ih >= 1776\n" +
                                        "epx inc 340 if ben <= 443\n" +
                                        "n dec 267 if fdv > -215\n" +
                                        "w dec -280 if jzm < -3113\n" +
                                        "oon dec 564 if epx > -2471\n" +
                                        "fdv dec -497 if oon > -4067\n" +
                                        "smi dec -22 if xo == -1442\n" +
                                        "tlj dec 592 if b >= 1772\n" +
                                        "jzm dec -637 if yrf <= 127\n" +
                                        "jzm inc -595 if ben < 438\n" +
                                        "k dec -75 if bwj > 4322\n" +
                                        "yrf inc -504 if b >= 1769\n" +
                                        "n dec 485 if yrf < -370\n" +
                                        "ben inc -379 if mx == 349\n" +
                                        "bwj inc -492 if epx <= -2473\n" +
                                        "ty dec 669 if blg >= 1019\n" +
                                        "bwj inc -607 if k > -1523\n" +
                                        "n dec 566 if ih <= 1784\n" +
                                        "rt dec 151 if ssv == -1134\n" +
                                        "epx dec 79 if vlh <= 687\n" +
                                        "mx inc 403 if xo != -1435\n" +
                                        "blg inc -458 if jzm == -3123\n" +
                                        "mx inc -850 if epx != -2546\n" +
                                        "ben dec -82 if blg == 560\n" +
                                        "ih inc -480 if mx <= -103\n" +
                                        "ty dec -197 if bwj > 3724\n" +
                                        "ben dec -252 if xo <= -1447\n" +
                                        "blg inc 522 if blg < 568\n" +
                                        "ke dec -376 if ih > 1771\n" +
                                        "b dec -354 if ben <= 66\n" +
                                        "sp dec 156 if w != 5241\n" +
                                        "n inc -140 if w != 5249\n" +
                                        "bwj dec -732 if ty >= 1737\n" +
                                        "oon inc 432 if epx < -2543\n" +
                                        "bwj dec 968 if fdv >= -208\n" +
                                        "mlp dec -879 if ih > 1767\n" +
                                        "xo inc 276 if jzm < -3119\n" +
                                        "oon dec -680 if blg >= 1088\n" +
                                        "vlh dec 623 if sp == -4710\n" +
                                        "ih dec -791 if xo <= -1165\n" +
                                        "fdv dec 52 if rt != 4120\n" +
                                        "oon dec 969 if n > -4042\n" +
                                        "oon dec -711 if jzm > -3129\n" +
                                        "ben inc -899 if vlh >= 679\n" +
                                        "fdv inc 604 if n > -4060\n" +
                                        "ssv inc 11 if jzm <= -3122\n" +
                                        "fdv dec -591 if smi <= 2884\n" +
                                        "mx inc -563 if w < 5252\n" +
                                        "tlj inc 518 if mx != -667\n" +
                                        "n inc 16 if ke == -2415\n" +
                                        "vlh inc 536 if w == 5244\n" +
                                        "ga dec -7 if rt == 4114\n" +
                                        "smi dec 349 if epx < -2556\n" +
                                        "k inc -719 if b < 2136\n" +
                                        "oon dec -522 if smi < 2886\n" +
                                        "ih inc 420 if ssv < -1109\n" +
                                        "w dec -812 if ssv == -1119\n" +
                                        "blg dec -731 if xo != -1173\n" +
                                        "vlh inc 670 if ssv != -1111\n" +
                                        "b inc 610 if k != -2227\n" +
                                        "ih inc 111 if fdv != 934\n" +
                                        "blg inc -579 if xo != -1163\n" +
                                        "rt inc -632 if w <= 6058\n" +
                                        "oon inc -124 if vlh != 1902\n" +
                                        "w dec 638 if bwj == 2754\n" +
                                        "bwj inc -192 if xo == -1166\n" +
                                        "tlj inc 252 if fdv < 942\n" +
                                        "jzm inc 96 if yrf <= -365\n" +
                                        "epx inc 42 if vlh >= 1891\n" +
                                        "n inc 580 if sp <= -4696\n" +
                                        "rt dec 264 if rt == 3482\n" +
                                        "b dec -219 if ssv < -1122\n" +
                                        "blg inc -307 if mx < -663\n" +
                                        "ke inc 613 if tlj > 3437\n" +
                                        "fdv inc 142 if k <= -2236\n" +
                                        "mx dec 548 if rt != 3224\n" +
                                        "jzm inc 580 if jzm >= -3036\n" +
                                        "tlj dec -910 if bwj == 2562\n" +
                                        "mlp inc -517 if vlh < 1899\n" +
                                        "ke inc 352 if ty == 1735\n" +
                                        "mlp inc -632 if rt == 3218\n" +
                                        "xo inc 766 if smi <= 2884\n" +
                                        "epx dec 912 if vlh >= 1896\n" +
                                        "epx inc 616 if mlp == 803\n" +
                                        "sp dec 233 if w >= 5417\n" +
                                        "xo inc 940 if ben <= -847\n" +
                                        "ih inc -398 if tlj >= 4355\n" +
                                        "n dec -660 if k <= -2224\n" +
                                        "w dec 697 if w <= 5410\n" +
                                        "ssv inc -26 if n < -2816\n" +
                                        "n inc 656 if oon == -1851\n" +
                                        "bwj dec 560 if xo < -397\n" +
                                        "ty dec -13 if mlp != 809\n" +
                                        "mlp dec 47 if blg < 1248\n" +
                                        "yrf dec -992 if ty == 1748\n" +
                                        "mx inc -563 if vlh <= 1901\n" +
                                        "oon dec 212 if fdv > 929\n" +
                                        "fdv inc 125 if smi < 2880\n" +
                                        "epx inc -256 if w <= 5421\n" +
                                        "yrf inc 998 if fdv <= 1068\n" +
                                        "smi dec -463 if ssv > -1129\n" +
                                        "smi inc 776 if oon <= -2064\n" +
                                        "mlp inc -334 if mx != -1770\n" +
                                        "tlj inc 420 if ty != 1756\n" +
                                        "yrf inc -801 if w > 5417\n" +
                                        "ty inc -561 if epx <= -2754\n" +
                                        "blg dec 104 if blg == 1240\n" +
                                        "fdv dec 772 if k > -2242\n" +
                                        "oon dec 885 if rt == 3218\n" +
                                        "sp dec 372 if rt == 3218\n" +
                                        "n dec 165 if ke <= -1446\n" +
                                        "smi dec -175 if xo <= -392\n" +
                                        "ke dec 524 if tlj >= 4768\n" +
                                        "vlh inc -101 if k > -2224\n" +
                                        "k inc 86 if ben < -833\n" +
                                        "bwj dec 622 if jzm < -2443\n" +
                                        "ke inc -437 if tlj <= 4781\n" +
                                        "tlj inc 287 if oon >= -2943\n" +
                                        "jzm dec -85 if vlh > 1886\n" +
                                        "xo inc 451 if blg != 1129\n" +
                                        "bwj inc 51 if vlh < 1896\n" +
                                        "blg dec 545 if ssv < -1114\n" +
                                        "blg dec 628 if ke != -2421\n" +
                                        "xo inc -592 if tlj == 4775\n" +
                                        "xo dec 799 if fdv >= 281\n" +
                                        "blg inc 250 if ssv < -1117\n" +
                                        "yrf inc -521 if w == 5418\n" +
                                        "ssv inc 494 if blg <= 222\n" +
                                        "ben inc -188 if mx <= -1773\n" +
                                        "sp dec -315 if mlp >= 421\n" +
                                        "ssv inc 995 if mx > -1777\n" +
                                        "ih dec -375 if n > -2324\n" +
                                        "epx inc 340 if ke >= -2416\n" +
                                        "mx inc 281 if fdv >= 295\n" +
                                        "blg inc 411 if sp < -4982\n" +
                                        "vlh inc -558 if sp < -4987\n" +
                                        "vlh inc 901 if jzm < -2353\n" +
                                        "sp dec -823 if epx < -2429\n" +
                                        "ga dec -945 if yrf != 296\n" +
                                        "k inc -144 if ty == 1187\n" +
                                        "yrf inc -907 if tlj != 4779\n" +
                                        "n dec 592 if k <= -2282\n" +
                                        "k dec 80 if sp != -4990\n" +
                                        "smi dec -914 if fdv == 290\n" +
                                        "b inc 690 if k >= -2362\n" +
                                        "epx inc 113 if ssv == 370\n" +
                                        "yrf inc -45 if blg <= 626\n" +
                                        "bwj dec -157 if ke < -2419\n" +
                                        "w inc -255 if ga != -2902\n" +
                                        "smi inc -481 if yrf != -647\n" +
                                        "xo dec 416 if ke == -2415\n" +
                                        "ih inc -18 if xo == -1756\n" +
                                        "blg dec -507 if w != 5167\n" +
                                        "tlj inc 865 if mlp != 419\n" +
                                        "w dec 660 if vlh < 2243\n" +
                                        "mlp inc 13 if fdv != 295\n" +
                                        "vlh dec 713 if mx < -1771\n" +
                                        "ke dec 537 if rt == 3208\n" +
                                        "mx dec -454 if ke >= -2410\n" +
                                        "mlp dec -858 if ty == 1187\n" +
                                        "yrf inc 655 if smi <= 3950\n" +
                                        "rt dec -215 if ty != 1187\n" +
                                        "sp dec 974 if fdv <= 295\n" +
                                        "b inc -347 if rt <= 3215\n" +
                                        "ssv dec -805 if ben < -830\n" +
                                        "ben inc 696 if n <= -2904\n" +
                                        "ke inc -141 if ty == 1195\n" +
                                        "oon inc -379 if ty <= 1195\n" +
                                        "bwj dec -798 if oon >= -3332\n" +
                                        "blg dec -888 if bwj >= 2235\n" +
                                        "ty inc -7 if rt != 3223\n" +
                                        "sp dec -651 if ssv < 1179\n" +
                                        "sp inc -104 if epx >= -2313\n" +
                                        "n dec -463 if ty > 1175\n" +
                                        "fdv inc -176 if jzm > -2369\n" +
                                        "tlj dec 395 if sp > -5422\n" +
                                        "tlj inc -382 if n <= -2447\n" +
                                        "n dec -309 if yrf > -4\n" +
                                        "ga inc 653 if mx > -1776\n" +
                                        "sp dec 774 if ssv >= 1184\n" +
                                        "smi dec -567 if mlp > 1290\n" +
                                        "ty dec 494 if xo <= -1753\n" +
                                        "fdv inc -734 if ga >= -2245\n" +
                                        "tlj dec 135 if bwj < 2232\n" +
                                        "n inc -536 if ih != 3047\n" +
                                        "mx dec -34 if b < 2748\n" +
                                        "epx inc 238 if oon == -3327\n" +
                                        "mlp dec 773 if w != 4510\n" +
                                        "smi inc 586 if tlj == 4728\n" +
                                        "sp inc -201 if n > -2683\n" +
                                        "w dec 463 if n != -2685\n" +
                                        "xo dec -487 if n == -2685\n" +
                                        "ssv inc -846 if yrf > -7\n" +
                                        "vlh inc -554 if vlh == 1523\n" +
                                        "oon inc 119 if rt != 3218\n" +
                                        "blg dec -243 if mlp <= 509\n" +
                                        "smi dec 526 if k == -2376\n" +
                                        "tlj dec -170 if blg < 1128\n" +
                                        "oon inc -371 if mx > -1741\n" +
                                        "jzm dec -129 if jzm > -2357\n" +
                                        "ih inc 573 if w > 4039\n" +
                                        "jzm inc -832 if ty >= 693\n" +
                                        "sp inc 419 if mx >= -1739\n" +
                                        "ssv inc 804 if sp <= -5201\n" +
                                        "yrf dec 310 if tlj >= 4736\n" +
                                        "tlj dec -274 if fdv >= -620\n" +
                                        "bwj inc -486 if yrf >= -10\n" +
                                        "blg inc 138 if xo <= -1761\n" +
                                        "n inc -940 if epx != -2071\n" +
                                        "xo inc -972 if tlj >= 4999\n" +
                                        "rt inc 522 if jzm < -2357\n" +
                                        "ga inc -397 if b != 2737\n" +
                                        "ty inc 799 if ssv < 1140\n" +
                                        "ih dec -938 if epx < -2079\n" +
                                        "n dec -590 if k > -2369\n" +
                                        "tlj dec 865 if sp >= -5201\n" +
                                        "ty inc -725 if oon < -3693\n" +
                                        "w dec -878 if xo != -2719\n" +
                                        "ih dec 618 if w > 4919\n" +
                                        "k inc -180 if bwj == 1743\n" +
                                        "xo inc -821 if ga > -2643\n" +
                                        "epx dec -892 if epx >= -2073\n" +
                                        "sp inc 428 if smi >= 5099\n" +
                                        "yrf dec 176 if n < -3609\n" +
                                        "xo inc -936 if tlj <= 4139\n" +
                                        "w inc -542 if fdv == -620\n" +
                                        "smi dec -714 if fdv != -624\n" +
                                        "ih dec -843 if ke < -2406\n" +
                                        "b dec 558 if yrf == -177\n" +
                                        "n dec -523 if sp >= -4781\n" +
                                        "n inc 938 if mx >= -1742\n" +
                                        "epx inc 973 if n > -2148\n" +
                                        "jzm inc 150 if fdv != -620\n" +
                                        "ih inc 673 if tlj != 4146\n" +
                                        "tlj inc -772 if n <= -2152\n" +
                                        "blg dec -155 if xo == -4485\n" +
                                        "epx dec 498 if oon >= -3695\n" +
                                        "ke inc -393 if oon > -3700\n" +
                                        "ssv dec -129 if oon > -3700\n" +
                                        "vlh inc 63 if mx >= -1740\n" +
                                        "ben inc -257 if xo <= -4487\n" +
                                        "rt dec 297 if oon == -3698\n" +
                                        "ty inc 347 if b <= 2188\n" +
                                        "ben inc -961 if xo < -4484\n" +
                                        "ih inc -624 if ssv < 1271\n" +
                                        "tlj inc 31 if k > -2557\n" +
                                        "epx inc -546 if bwj > 1734\n" +
                                        "blg dec 580 if fdv <= -615\n" +
                                        "fdv dec -170 if mx <= -1729\n" +
                                        "yrf inc 475 if ssv > 1261\n" +
                                        "vlh dec 822 if b == 2182\n" +
                                        "ty inc -414 if blg == 706\n" +
                                        "mx dec -871 if ih < 4518\n" +
                                        "ben dec 908 if mlp == 519\n" +
                                        "b inc 50 if ke >= -2809\n" +
                                        "mlp inc 904 if ty < 697\n" +
                                        "blg inc -465 if vlh != 209\n" +
                                        "b inc -71 if k < -2543\n" +
                                        "mx dec -420 if epx == -1726\n" +
                                        "ty dec -193 if jzm >= -2370\n" +
                                        "vlh dec -526 if ke < -2814\n" +
                                        "ben inc -121 if jzm != -2362\n" +
                                        "ga dec -892 if ih == 4522\n" +
                                        "vlh dec -607 if vlh != 210\n" +
                                        "bwj inc 569 if xo < -4487\n" +
                                        "tlj dec 514 if tlj < 3395\n" +
                                        "smi dec -221 if ih <= 4522\n" +
                                        "ssv inc 621 if b < 2171\n" +
                                        "k inc -185 if rt != 3439\n" +
                                        "blg dec -42 if ssv >= 1890\n" +
                                        "ssv inc 24 if ty > 891\n" +
                                        "yrf inc 572 if n < -2153\n" +
                                        "ben inc 920 if mlp == 1423\n" +
                                        "b inc -699 if mx > -1325\n" +
                                        "blg dec 952 if k != -2732\n" +
                                        "b dec 96 if blg != -708\n" +
                                        "vlh inc -200 if sp != -4763\n" +
                                        "xo inc -741 if epx > -1731\n" +
                                        "ga inc 944 if w >= 4370\n" +
                                        "oon inc 652 if rt != 3451\n" +
                                        "mlp dec -710 if ty > 883\n" +
                                        "vlh dec -121 if ke >= -2801\n" +
                                        "bwj inc -490 if smi >= 6032\n" +
                                        "xo dec -678 if xo == -5226\n" +
                                        "epx inc -796 if oon != -3039\n" +
                                        "ssv inc -339 if xo < -4547\n" +
                                        "smi inc -30 if rt > 3440\n" +
                                        "b inc 476 if ssv != 1553\n" +
                                        "xo inc 155 if smi < 6014\n" +
                                        "k dec -79 if sp <= -4766\n" +
                                        "mlp inc 592 if k != -2656\n" +
                                        "epx dec 74 if rt < 3445\n" +
                                        "tlj dec -575 if n >= -2149\n" +
                                        "vlh inc 34 if mlp == 2133\n" +
                                        "ty dec -648 if epx >= -2604\n" +
                                        "mx inc 146 if fdv >= -454\n" +
                                        "mx dec -212 if ke < -2812\n" +
                                        "vlh inc 635 if smi < 6008\n" +
                                        "k inc 7 if sp != -4778\n" +
                                        "oon inc 832 if fdv <= -447\n" +
                                        "rt inc -936 if ih >= 4518\n" +
                                        "b inc -236 if blg == -711\n" +
                                        "oon inc -650 if oon > -2221\n" +
                                        "xo inc -397 if vlh == 679\n" +
                                        "ih inc -248 if sp >= -4777\n" +
                                        "rt inc -904 if k == -2649\n" +
                                        "mx inc -222 if sp != -4780\n" +
                                        "yrf inc -793 if jzm >= -2362\n" +
                                        "bwj dec -186 if oon < -2861\n" +
                                        "n inc 812 if epx <= -2589\n" +
                                        "w dec 315 if vlh != 682\n" +
                                        "blg inc 840 if tlj > 3391\n" +
                                        "mlp inc -203 if epx < -2591\n" +
                                        "mx inc -959 if ben <= -1090\n" +
                                        "jzm inc 360 if ke > -2812\n" +
                                        "xo inc -131 if n >= -1348\n" +
                                        "tlj dec -618 if jzm < -1997\n" +
                                        "blg dec 440 if b > 1598\n" +
                                        "oon dec 293 if ke < -2802\n" +
                                        "ih dec 391 if ih == 4274\n" +
                                        "ke dec -141 if ssv > 1546\n" +
                                        "epx dec 995 if vlh > 672\n" +
                                        "yrf inc 860 if ga < -808\n" +
                                        "jzm dec 594 if bwj != 1443\n" +
                                        "fdv inc 172 if sp > -4775\n" +
                                        "sp dec -473 if xo <= -4922\n" +
                                        "ga inc -813 if jzm < -2601\n" +
                                        "epx inc -554 if fdv == -278\n" +
                                        "jzm dec -716 if bwj >= 1433\n" +
                                        "b dec 523 if sp == -4773\n" +
                                        "vlh dec 474 if oon > -3161\n" +
                                        "tlj dec 219 if ga == -805\n" +
                                        "blg inc -824 if ga >= -810\n" +
                                        "bwj dec 266 if yrf != 68\n" +
                                        "epx dec -138 if ben <= -1083\n" +
                                        "oon dec 627 if yrf > 76\n" +
                                        "ben dec -908 if bwj <= 1179\n" +
                                        "epx dec -121 if n > -1352\n" +
                                        "ssv dec -173 if rt < 1604\n" +
                                        "rt dec -458 if ty != 1524\n" +
                                        "yrf dec 236 if epx != -3888\n" +
                                        "mx dec -391 if jzm >= -1881\n" +
                                        "bwj dec 534 if w > 4052\n" +
                                        "b inc -959 if tlj < 3798\n" +
                                        "ty dec -868 if vlh != 211\n" +
                                        "jzm inc 728 if smi == 6007\n" +
                                        "yrf dec -584 if ty > 2399\n" +
                                        "smi dec 905 if yrf <= 434\n" +
                                        "vlh inc 455 if ssv != 1717\n" +
                                        "fdv dec 959 if jzm >= -1160\n" +
                                        "jzm dec -870 if rt <= 2069\n" +
                                        "k inc -635 if rt > 2057\n" +
                                        "b dec 710 if vlh > 198\n" +
                                        "blg inc -456 if ben <= -174\n" +
                                        "ga inc 580 if sp != -4774\n" +
                                        "bwj inc 762 if ssv < 1722\n" +
                                        "mx inc 405 if jzm == -282\n" +
                                        "ben inc -838 if n > -1350\n" +
                                        "ben inc 360 if sp >= -4777\n" +
                                        "ke inc 164 if rt < 2068\n" +
                                        "mx dec 891 if b != -595\n" +
                                        "jzm dec -395 if w != 4052\n" +
                                        "k dec -690 if xo < -4920\n" +
                                        "ga inc -272 if ty < 2406\n" +
                                        "xo inc 131 if b != -595\n" +
                                        "k inc -214 if vlh > 201\n" +
                                        "ssv dec 122 if vlh == 205\n" +
                                        "ga dec 603 if blg < -1588\n" +
                                        "vlh inc 770 if oon > -3789\n" +
                                        "epx dec -187 if ga > -1101\n" +
                                        "oon inc -128 if yrf > 421\n" +
                                        "ty dec -781 if oon >= -3916\n" +
                                        "ben dec -334 if epx != -3694\n" +
                                        "fdv inc 137 if ben >= -330\n" +
                                        "vlh dec 92 if fdv < -1098\n" +
                                        "jzm inc -413 if ga <= -1097\n" +
                                        "vlh dec 758 if sp < -4764\n" +
                                        "tlj inc -754 if xo > -4788\n" +
                                        "jzm dec 79 if mx >= -2449\n" +
                                        "bwj dec 983 if w != 4067\n" +
                                        "fdv inc -819 if b != -586\n" +
                                        "epx inc 615 if jzm >= -373\n" +
                                        "mlp inc -871 if fdv >= -1108\n" +
                                        "ih inc -945 if b < -576\n" +
                                        "mx dec -934 if w == 4068";
}
