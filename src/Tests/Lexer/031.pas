program tet;
var 
    n: longint;
    sum: integer;
begin
    readln(n);   
    sum := 0;
    while n > 0 do begin
        if n mod 10 mod 2 = 0 then
            sum := sum + n mod 10;
        n := n div 10;
    end;    
    writeln(sum);
end.