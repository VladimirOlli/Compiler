program ya_ystal;
var
    x,y: real;
 
begin
    write ('x = '); read (x);
    write ('y = '); readln (y);
 
    write ('nomer ');
    if (x > 0) and (y > 0) then
        writeln ('I')
    else
        if (x < 0) and (y > 0) then
            writeln ('II')
        else
            if (x < 0) and (y < 0) then
                writeln ('III')
            else
                if (x > 0) and (y < 0) then
                    writeln ('IV')
                else
                    writeln ('-. tochka na osi');
 
readln
end.