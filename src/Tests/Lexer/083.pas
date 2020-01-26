program uuuewuej;
const n = 10;
var
	arr: array[1..n] of integer;
	i, count, summa, min_id: integer;
	mean: real;
begin
    count := 0;
    summa := 0;
    min_id := 0;
 
    for i:=1 to n do begin
		read(arr[i]);
		if arr[i] < 0 then begin
			count := count + 1;
			summa := summa + arr[i];
			if arr[i] < arr[min_id] then
				min_id := i;
		end;
	end;
 
    mean := summa/count;
    arr[min_id] := round(mean);
    writeln('Count: ', count);
    writeln('Mean: ', mean:6:2);
    writeln('New array: ');
    for i:=1 to n do
		write(arr[i], ' ');
	writeln;
end.