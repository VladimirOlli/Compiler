program  n_5_1;
  var n, i: integer; 
      a: array[1..10] of integer;
begin 
  randomize;
  for i:=1 to 10 do a[i]:=random(100);
  for i:=1 to 10 do write(a[i],' ');

  i:=0;
  repeat
    i:=i+1;
  until (a[i]=50) or (i=10);

  if a[i]=50 then
    write(i) 
  else 
    write('none')
end.