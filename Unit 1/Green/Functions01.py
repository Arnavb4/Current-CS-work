def malcolm(x):
  return 2 * x + 1


def elaisa(x, y):
  return 2*x-y     


def akash(a):
  if a>0:
    return 1
  else:
    return -1     


def rosa(x):
  return -1*(malcolm(x-1))      


def aashni(q):
  return (akash(q))*q  


def dion(n):
  if n>10:
    return malcolm (n)
  else:
    return rosa (n)     


def zhixing(a, b):
  return (elaisa(aashni(a),rosa(b)))*2


