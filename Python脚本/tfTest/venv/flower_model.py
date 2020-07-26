
import tensorflow as tf
import numpy as np
try:
    import tensorflow.python.keras as keras
except:
    import tensorflow.keras as keras
from tensorflow.keras import layers
from tensorflow.keras.models import Sequential


def get_flower_model():
    model = Sequential()
    #通道个数 卷积核大小 激活函数
    model.add(layers.Conv2D(input_shape=(100, 100, 3), filters=32, kernel_size=(3, 3), activation='relu'))
    #池化层大小
    model.add(layers.MaxPool2D((2, 2)))
    #防止过拟合
    model.add(layers.Dropout(0.25))

    model.add(layers.Conv2D(filters=64, kernel_size=(3, 3), activation='relu'))
    model.add(layers.MaxPool2D((2, 2)))
    model.add(layers.Dropout(0.25))

    model.add(layers.Flatten(input_shape=(64, 64)))
    model.add(layers.Dense(512, activation='relu'))
    model.add(layers.Dropout(0.2))
    model.add(layers.Dense(5, activation='softmax'))
    return model
