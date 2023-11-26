#How?


    Examples: a0. a : Armor 0 : Cracked Bat. Code for that : ArmorNames[Item.iID]; 
    Returns: "Cracked Bat". Your Welcome github ppl ~Leviathenn
    
     a0 = a | 0. now they are split a0 is now a | 0. Lets check our new array. Array: [a, 0]
       The first letter in our array is a. 'a' corrosponds to the Category.
     'a' Stands for the Armor Category, so when we check for item ids, we will check in th armor class.
      '0' stands for the index that we search for in the ArmorNames array. 
     ArmorNames Array Example: {" Cracked Bat ", "Stone CHestplate", "Stone Helment"};
     Lets check our array: {" Cracked Bat ", "Stone CHestplate", "Stone Helment"}. Looks good.
     But we need to label our Indexs, Since were not writing the actual code. Lets take a look!
     {" Cracked Bat ": 0, "Stone CHestplate": 1, "Stone Helment": 2};
     As we can see. For example, The Item "Cracked Bat" has the ID 0 in the Armor Category!
     Now, do you see how 'a0' expands to Cracked Bat?
     a: Armor, 0: ID! That Simple
     
     When PWITZEL(Preston) and I(Leviathenn) are writing the code, we make short cuts.
     These "shortcuts" are very complacted and long lines. 
     for example, a short cut i wrote is:
     iID = Integer.parseInt(sID.split(sID.substring(0, 1))[1]); 
     Looks complacted right?
     All it does is splits the Long id(a0) into two parts. a & 0. or in array form [a, 0].
     It does this by using subString to find the first character. aka a.
     than it splits the character a from a0. and we get the array form [a, 0];
     [a, 0] labeled is [a: 0, 0: 1].
     and as you cann see by doing [1] we get the last token in our array. aka "0".
     but in code form the zero is still a string. aka "0". we need it to be a integer aka 0.
     So we use "Integer.parseInt" to turn that String into an int. And there you go!
     The code is actuly really simple, but looks complacted.
     
     HAPPY CODING!
     

#Documentation presented by @Leviathenn. The person who wrote the inventory & save file code.
     
     
     
     