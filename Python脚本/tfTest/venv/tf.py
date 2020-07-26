"""
import tensorflow as tf
import numpy as np
try:
    import tensorflow.python.keras as keras
except:
    import tensorflow.keras as keras
from tensorflow.python.keras import layers

mnist = keras.datasets.mnist
(x_train,y_train),(x_test,y_test) = mnist.load_data()
x_train, x_test = x_train/255.0, x_test/255.0  # 除以 255 是为了归一化。

# Sequential 用于建立序列模型
# Flatten 层用于展开张量，input_shape 定义输入形状为 28x28 的图像，展开后为 28*28 的张量。
# Dense 层为全连接层，输出有 128 个神经元，激活函数使用 relu。
# Dropout 层使用 0.2 的失活率。
# 再接一个全连接层，激活函数使用 softmax，得到对各个类别预测的概率。
model = keras.Sequential()
model.add(layers.Flatten(input_shape=(28,28)))
model.add(layers.Dense(128,activation="relu"))
model.add(layers.Dropout(0.2))
model.add(layers.Dense(10,activation="softmax"))

# 优化器选择 Adam 优化器。
# 损失函数使用 sparse_categorical_crossentropy，
# 还有一个损失函数是 categorical_crossentropy，两者的区别在于输入的真实标签的形式，
# sparse_categorical 输入的是整形的标签，例如 [1, 2, 3, 4]，categorical 输入的是 one-hot 编码的标签。
model.compile(optimizer="adam",
              loss="sparse_categorical_crossentropy",
              metrics=['accuracy'])

# fit 用于训练模型，对训练数据遍历一次为一个 epoch，这里遍历 5 次。
# evaluate 用于评估模型，返回的数值分别是损失和指标。
model.fit(x_train,y_train,epochs=5)
model.evaluate(x_test,y_test)
"""


#获得数据集标签集

import tensorflow as tf
import skimage
from data_loader import load_flower_data
from flower_model import get_flower_model
import matplotlib.pyplot as plt
from skimage import io, transform
import numpy as np
import TCPhandler
import socketserver
from TCPhandler import myTCPhandler

#import pydotplus
#import keras.utils

#print('tf__version__')
#model = get_flower_model()
#model.compile(optimizer='adam',
#              loss='sparse_categorical_crossentropy',
#             metrics=['accuracy'])

#(x_train, y_train), (x_test, y_test) = load_flower_data()


#训练模型
#model.fit(x_train, y_train, epochs=10, batch_size=32)

#保存训练参数
#model.save('cnn_model.h5')


model = tf.keras.models.load_model('cnn_model.h5')

#评估模型
#test_loss, test_acc = model.evaluate(x_test, y_test, batch_size=32)
#print(test_acc)
#print(test_loss)


#plt.imshow(x_train[0])
#plt.show()
#print(x_train.shape)


#img = io.imread('D:\\flower_photos\\daisy\\5547758_eea9edfd54_n.jpg')
#img=io.imread('D:\\flower_photos\\roses\\12240303_80d87f77a3_n.jpg')
#img = transform.resize(img, (100, 100))
#print(img)
#print("---------------")
#img = np.array([img], dtype=('float'))
#print(img)
#result = model.predict(img)
#print(result)
#print(result)


def show_result(path):
    img = io.imread(path)
    img = transform.resize(img, (100, 100))
    img = np.array([img], dtype=('float'))
    result = model.predict(img)
    print(result)


if __name__ == '__main__':
    model = tf.keras.models.load_model('cnn_model.h5')
    #keras.utils.vis_utils.pydot = pydotplus
    #keras.utils.plot_model(model, to_file='model.png', show_shapes=True)
    #host = '127.0.0.1'
    host = '172.20.10.2'
    port = 9007
    server = socketserver.ThreadingTCPServer((host, port), myTCPhandler)
    server.serve_forever()