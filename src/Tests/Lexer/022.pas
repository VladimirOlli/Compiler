﻿const n = 10; { }
var a:array[1..n] of integer;
    i,j,x:integer;
begin
     writeln('enter ',n,' mass');
     for i:=1 to n do readln( a[i] );
 
     for i:=1 to n-1 do begin
         for j:=i+1 to n do begin
           if a[i]>a[j] then begin
              x:=a[i]; a[i]:=a[j]; a[j]:=x;
           end;
         end;
     end;
     writeln('After sort:');
     for i:=1 to n do writeln( a[i] );
end.