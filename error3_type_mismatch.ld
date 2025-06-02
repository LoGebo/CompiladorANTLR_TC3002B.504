program ErrorTest3;
var 
    x : int;
    y : float;
main()
{
    y = 3.14;
    x = y;  // Error: no se puede asignar float a int (pérdida de precisión)
}
end. 