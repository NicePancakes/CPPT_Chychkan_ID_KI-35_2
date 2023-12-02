from enum import Enum
from Bullet import Bullet

class SmartBullet(Bullet):
  def __init__(self, name: str, size: float, intact: bool, target: str):
    super().__init__(name, size, intact)
    self.__target = target

  def getTarget(self): return self.__target
  def setTarget(self, target: str): self.__target = target
