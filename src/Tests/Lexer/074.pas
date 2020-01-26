program CountSpacesInString;
var
  str: string;

function CountSpaces (s: string): integer;
var
   i, count: integer;
begin
  count := 0;
  for i:=1 to length(s) do
  if s[i]=' ' then
  count := count+1;
  CountSpaces := count;
end;


begin
  writeln('probel '+'v stroke');
    repeat
       writeln('enter text:');
       readln(str);
         if (length(str)<1) then
            writeln('');
    until length(str)>0;
writeln('in stroka "',str,'" ',CountSpaces(str),' space');

readln;
end.