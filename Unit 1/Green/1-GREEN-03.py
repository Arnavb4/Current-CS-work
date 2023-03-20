def bool_myst_A(x):
    if (x%2)==0:
        return True
    elif (x%3)==0:
        return True
    else:
        return False

def bool_myst_B(x):
    if x > 10:
        return True
    else:
        if (x%2)==0:
            return True
        else:
            return False

def bool_myst_C(x):
    if (x%3)==0:
        return False
    else:
        return True

def bool_myst_D(x):
    if (x%10)==0:
        return True
    elif (x%10)==1:
        return True
    elif (x%10)==2:
        return True
    elif (x%10)==3:
        return True
    else:
        return False

def bool_myst_E(x):
    if(x%3)==0:
        return False
    elif(x%5)==0:
        return False
    else:
        return True

def bool_myst_F(x):
    if(x%10)==0:
        return False
    elif(x%10)==1:
        return False
    elif(x%10)==2:
        return False
    elif(x%10)==3:
        return False
    elif(x%10)==4:
        return False
    else:
        return True

def date_fashion(you, date):
  if you <= 2 or date <= 2:
      return 0
  elif you >= 8 or date >= 8:
    return 2
  else:
    return 1

def squirrel_play(temp, is_summer):
  if is_summer:
    if temp >= 60 and temp <=100:
      return True
    else:
      return False
  elif not is_summer:
    if temp>= 60 and temp <=90:
      return True
    else:
      return False

def caught_speeding(speed, is_birthday):
  if is_birthday:
    if speed <= 65:
      return 0
    if speed >= 66 and speed <=85:
      return 1
    if speed >= 86:
      return 2
  else:
    if speed <= 60:
      return 0
    if speed >= 61 and speed <=80:
      return 1
    if speed >= 81:
      return 2

def sorta_sum(a, b):
  sum = a + b
  if sum >= 10 and sum <= 19:
    return 20
  return sum

def alarm_clock(day, vacation):
  if vacation:
    if day == 1 or day == 2 or day == 3 or day == 4 or day == 5:
      return '10:00'
    elif day ==6 or day ==0:
      return 'off'
  elif not vacation:
    if day == 1 or day == 2 or day == 3 or day == 4 or day == 5:
      return '7:00'
    elif day ==6 or day == 0:
      return '10:00'

def love6(a, b):
  if a == 6 or b == 6:
    return True
  elif a + b ==6:
    return True
  elif a - b ==6:
    return True
  elif b - a == 6:
    return True
  else:
    return False

def in1to10(n, outside_mode):
  if outside_mode:
    if n <= 1 or n >= 10:
      return True
    else:
      return False
  elif n >= 1 and n <= 10:
    return True
  else:
    return False

def near_ten(num):
  if (num % 10) <= 2:
    return True
  elif 10 - (num % 10) <=2:
    return True
  else:
    return False