class Character:
    def __init__(self, name, health):
        self.name = name
        self.health = health

    def get_health(self):
        return self.health


class Goodie(Character):
    def __init__(self, name, health, catchphrase):
        super().__init__(name, health)
        self.catchphrase = catchphrase

    def get_catchphrase(self):
        return self.catchphrase


class Baddie(Character):
    def __init__(self, name, health, getaway_vehicle, villainous_pet):
        super().__init__(name, health)
        self.getaway_vehicle = getaway_vehicle
        self.villainous_pet = villainous_pet

    def get_villainous_pet(self):
        return self.villainous_pet

    def get_getaway_vehicle(self):
        return self.getaway_vehicle
