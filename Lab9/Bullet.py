class Bullet:
  def __init__(self, name: str, size: float, intact: bool):
    self.__name = name
    self.__size = size
    self.__intact = intact

  def getName(self) -> str: return self.__name
  def setName(self, name): self.__name = name
  
  def getSize(self) -> float: return self.size
  def setSize(self, size): self.__size = size

  def getIntact(self) -> int: return self.__intact
  def setIntact(self, intact): self.__intact = intact
