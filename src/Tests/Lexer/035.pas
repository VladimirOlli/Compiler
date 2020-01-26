program jju;
var
    str1,str2,str3: string;
    l,i: byte;    
begin
    readln(str1);
    str2 := '';
    str3 := '';
    l := length(str1);
    for i:=1 to l do
        if odd(i) then
            str3 := str3 + str1[i]
        else
            str2 := str2 + str1[i];
    writeln(str2);
    writeln(str3);
end.