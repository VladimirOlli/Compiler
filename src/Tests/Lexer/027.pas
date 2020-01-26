program f44;
const n = 3; { }
var   a:array[1..n] of integer;
      index : integer;
 
procedure generate (l,r:integer);
var i,v:integer;
begin
      if (l=r) then begin
        for i:=1 to n do write(a[i],' ');
        writeln;
      end else begin
        for i := l to r do begin
           v:=a[l]; a[l]:=a[i]; a[i]:=v; 
           generate(l+1,r);             
           v:=a[l]; a[l]:=a[i]; a[i]:=v; { a[i],a[j]}
        end;
      end;
end;
 
begin
      for index := 1 to N do A[index]:=index;
      generate( 1,n );
end.