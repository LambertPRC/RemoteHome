from skimage import io, transform
import glob
import os
import tensorflow as tf
import numpy as np
import time

path = 'D:\\flower_photos\\'
w = 100
h = 100


#获得训练集
def get_train_data():
    cate = [path + x for x in os.listdir(path) if os.path.isdir(path + x)]
    imgs = []
    labels = []
    for idx, folder in enumerate(cate):
        for im in glob.glob(folder + '/*.jpg'):
            #print('reading the images:%s' % im)
            img = io.imread(im)
            img = transform.resize(img, (w, h))
            imgs.append(img)
            labels.append(idx)
    return np.asarray(imgs, np.float32), np.asarray(labels, np.int32)


def resetting_data_set():
    data, label = get_train_data()
    num_example = data.shape[0]
    arr = np.arange(num_example)
    np.random.shuffle(arr)
    data = data[arr]
    label = label[arr]
    ratio = 0.8
    s = np.int(num_example * ratio)
    x_train = data[:s]
    y_train = label[:s]
    x_test = data[s:]
    y_test = label[s:]
    return (x_train, y_train), (x_test, y_test)


def save_data(flower_data):
    (x_train, y_train), (x_test, y_test) = resetting_data_set()
    np.savez('{}{}'.format(path, flower_data), x_train=x_train, x_test=x_test, y_train=y_train, y_test=y_test)


#save_data('flower')


def load_flower_data():
    data = np.load('{}{}.npz'.format(path, 'flower'))
    x_train = data['x_train']
    y_train = data['y_train']
    x_test = data['x_test']
    y_test = data['y_test']
    return (x_train, y_train), (x_test, y_test)


