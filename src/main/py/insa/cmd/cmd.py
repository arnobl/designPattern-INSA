class Accumulator(object):
    def __init__(self, n):
        self.n = n
    def __call__(self, x):
        self.n += x
        return self.n