program TestControl;
var 
    count : int;
main()
{
    count = 0;
    if (count < 5) {
        print("Menor que 5");
    } else {
        print("Mayor o igual a 5");
    }
    
    while (count < 3) do {
        count = count + 1;
        print("Iteracion while:", count);
    }
    
    do {
        count = count - 1;
        print("Iteracion do-while:", count);
    } while (count > 0);
}
end. 