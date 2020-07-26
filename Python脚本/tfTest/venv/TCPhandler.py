import socketserver
import base64
from skimage import io, transform
import numpy as np
import tensorflow as tf
import json


class myTCPhandler(socketserver.BaseRequestHandler):
    def handle(self):
        while True:
            # 65535? 1024?
            self.data = self.request.recv(131070).decode('UTF-8', 'ignore').strip()
            if not self.data: break
            print(self.data)
            # list.append(self.data)
            img = base64.b64decode(self.data)
            fh = open("pic.png", "wb")
            fh.write(img)
            fh.close()
            img=io.imread('D:\\Program Files (x86)\\PycharmProjects\\tfTest\\venv\\pic.png')
            #img = io.imread('D:\\flower_photos\\daisy\\5547758_eea9edfd54_n.jpg')
            img = transform.resize(img, (100, 100))
            img = np.array([img], dtype=('float'))
            model = tf.keras.models.load_model('cnn_model.h5')
            result = model.predict(img)
            b = [str(j) for j in result]
            str2 = ''.join(b)
            #self.feedback_data = ("back\"" + "\":\n\thello,I am Server\n"+str2).encode("utf8")
            self.feedback_data=(str2).encode("utf8")
            # print("Send successfully！")
            self.request.sendall(self.feedback_data)
