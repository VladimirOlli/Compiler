program  n_5;

var   n, i: integer; 
      a: array[1..10] of integer;

begin 
  randomize;

  for i:=1 to 10 do a[i]:=random(100);
  for i:=1 to 10 do write(a[i],' ');

  n:=0;
  for i:=1 to 10 do
    if a[i]=50 then
       n:=i;

  if n=0 then
     write('nety')
  else
     write(n)

end.