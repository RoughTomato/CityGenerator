from setuptools import setup

setup(
    name='citygeneratorTools',
    version='0.1',
    description='Series of tools that are useful during development of citygenerator project.',
    url='https://github.com/RoughTomato/CityGenerator/tools',
    author='Amadeusz Dabkowski',
    author_email='adabkowski93@gmail.com',
    license='GPLv3',
    packages=['citygeneratortools'],
    install_requires=[
        'argparse',
        'pytest'
    ],
    zip_safe=False
    )
