﻿var s:string;
    i,j,n:integer;
begin
    readln(s);
    s:=s[length(s)] + copy(s,1,length(s)-1);
    writeln(s);
end.