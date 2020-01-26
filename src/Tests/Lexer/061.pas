program iit;
var
    k, l: integer;
 
procedure exchange (var a,b: integer);
    var c: integer;
    begin
        if a > b then begin
            c := a;
            a := b;
            b := c;
        end;
    end;
 
begin
 
    writeln ('enter: ');
    readln (k, l);
 
    exchange (k, l);
 
    writeln ('k = ', k,'; l = ', l);
 
readln
end.